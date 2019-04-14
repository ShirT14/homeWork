package db.coupons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ConnectionPool {
	private static Set<Connection> connections = new HashSet<>();
	private int maxConnections = 10;

	public int getMaxConnections() {
		return maxConnections;
	}

	public static Set<Connection> getConnections() {
		return connections;
	}

	public String getUrl() {
		return url;
	}

	private String url = "jdbc:derby://localhost:1527/CouponsSystemDB";

	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getInstance() {
		return instance;
	}

	private ConnectionPool() {
		// add 10 connections to the set
		for (int i = 0; i < maxConnections; i++) {
			try {
				connections.add(DriverManager.getConnection(url));
				connections.iterator().next();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public synchronized Connection getConnection() throws InterruptedException {
		while (connections.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Connection availableConnection = ConnectionPool.getConnections().iterator().next();
		getConnections().remove(availableConnection);

		return availableConnection;
	}

	public void restoreConnection(Connection connection) {
		connections.add(connection);
		notifyAll();

	}

	public void closeAllConnections() {

		for (int i = 0; i < maxConnections; i++) {
			try {
				connections.iterator().next().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
