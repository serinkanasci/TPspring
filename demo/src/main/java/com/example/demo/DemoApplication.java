package com.example.demo;

// // SERIALIZATION
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// @RestController
public class DemoApplication {

	// @GetMapping(value = "/hello")
	// public String getMethodName() {
		
		

	// 	return "Hello";
	// }

	public static void main(String[] args) {
		// // SERIALIZATION
		// // on simplifie le code en retirant la gestion des exceptions
		// File fichier =  new File("tmp/marin.ser") ;

		// // ouverture d'un flux sur un fichier
		// ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
			
		// // création d'un objet à sérializer
		// Cours javaSpring =  new Cours() ;

		// // sérialization de l'objet
		// oos.writeObject(javaSpring) ;

		// // DESERIALIZATION

		// // ouverture d'un flux sur un fichier
		// ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
				
		// // désérialization de l'objet
		// Cours javaSpring = (Cours)ois.readObject() ;
		// System.out.println(javaSpring) ;
		SpringApplication.run(DemoApplication.class, args);

		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory fac = new XmlBeanFactory(r);

		Cours cours1 = (Cours)fac.getBean("Cours");
		Cours cours2 = (Cours)fac.getBean("Cours2");
		Coach patrick = (Coach)fac.getBean("Coach");
		Objectif obj1 = (Objectif)fac.getBean("Objectif1");
		Objectif obj2 = (Objectif)fac.getBean("Objectif1.2");
		Objectif obj3 = (Objectif)fac.getBean("Objectif2");

		patrick.addCours(cours1);
		patrick.addCours(cours2);
		cours1.addObjectif(obj1);
		cours1.addObjectif(obj2);
		cours2.addObjectif(obj3);

		
		patrick.afficher();
		cours1.afficher();
		cours2.afficher();
		obj1.afficher();
		obj2.afficher();
		obj3.afficher();

	}

}
