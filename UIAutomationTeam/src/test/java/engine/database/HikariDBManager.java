package engine.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Centralized database connection manager based on HikariCP.
 * <p>
 * This class maintains a pool of {@link HikariDataSource} instances per unique
 * connection configuration (database type, server, port, and database name).
 * Each unique combination creates and reuses its own pool, avoiding unnecessary
 * recreation and improving performance.
 * </p>
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class HikariDBManager {

	private static ConcurrentHashMap<String, HikariDataSource> poolOfDBConnections = new ConcurrentHashMap<>();

	private static HikariDataSource createDatasourceForDatabaseConnection(DatabaseType databaseType, String server, String port, String database, String username, String password) {
		HikariConfig config = new HikariConfig();
		switch (databaseType) {
		case MYSQL:
			config.setJdbcUrl("jdbc:mysql://" + server + ":" + port + "/" + database);
			config.setUsername(username);
			config.setPassword(password);
			break;
		case ORACLE:
			config.setJdbcUrl("jdbc:oracle:thin:@" + server + ":" + port + ":" + database);
			config.setUsername(username);
			config.setPassword(password);
			break;
		case POSTGRES:
			config.setJdbcUrl("jdbc:postgresql://" + server + ":" + port + "/" + database);
			config.setUsername(username);
			config.setPassword(password);
			break;
		default:
			throw new IllegalArgumentException("DB not supported");
		}
		config.setMaximumPoolSize(4);
		config.setConnectionTimeout(5000);
		config.setIdleTimeout(30000);
		config.setMinimumIdle(1);
		config.setMaxLifetime(1800000);
		return new HikariDataSource(config);
	}

	
	/**
	 * Retrieves an active {@link Connection} from a pooled {@link ConcurrentHashMap} containing multiples {@link HikariDataSource}.
	 * <p>
	 * A unique key is generated based on the provided parameters. If a pool does not
	 * exist for this configuration, it will be created automatically. Otherwise,
	 * the existing pool will be reused.
	 * </p>
	 *
	 * @param databaseType Type of database
	 * @param server Database server address
	 * @param port Database port
	 * @param database Database/schema name
	 * @param username Authentication username
	 * @param password Authentication password
	 * @return A live SQL {@link Connection} from the pool
	 * @throws SQLException if a connection cannot be obtained
	 */
	public static Connection ConnectToDatabase(DatabaseType databaseType, String server, String port, String database, String username, String password) throws SQLException {
		String key = databaseType + "_" + server + "_" + port + "_" + database;
		HikariDataSource ds = poolOfDBConnections.computeIfAbsent(key, k -> createDatasourceForDatabaseConnection(databaseType, server, port, database, username, password));
		return ds.getConnection();
	}
}
