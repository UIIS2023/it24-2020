package singleton;

public class DatabaseConnectionLazy {

	private static DatabaseConnectionLazy instance;

	DatabaseConnectionLazy() {

	}

	public static DatabaseConnectionLazy getInstance() {

		if (instance == null) {
			synchronized (DatabaseConnectionLazy.class) {
				if (instance == null) {
					instance = new DatabaseConnectionLazy();
				}

			}

		}
		return instance;
	}

}
