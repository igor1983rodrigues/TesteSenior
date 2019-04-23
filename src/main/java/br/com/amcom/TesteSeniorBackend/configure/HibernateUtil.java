package br.com.amcom.TesteSeniorBackend.configure;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry = null;
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		return getSessionFactory(null);
	}

	public static SessionFactory getSessionFactory(String resourceName) {
		if (sessionFactory == null) {
			try {
				if (resourceName == null) {
					registry = new StandardServiceRegistryBuilder().configure(resourceName).build();
				} else {
					registry = new StandardServiceRegistryBuilder().configure().build();
				}
				MetadataSources sources = new MetadataSources(registry);
				Metadata metadata = sources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception ex) {
				ex.printStackTrace();
				closeAllConnections();
			}

		}

		return sessionFactory;
	}

	public static void closeAllConnections() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}