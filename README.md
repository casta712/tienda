# tienda
---------------------------------Desarrollo de Módulos en Spring-Boot para Backend

-----------1. codificación en Spring-boot 
Spring-Boot es un marco robusto que facilita la creación de aplicaciones basadas en Spring. En este documento, describiremos cómo codificar módulos específicos, enfocándonos en un caso práctico de gestión de productos y local.

-----------1.1.  Estructura del Proyecto
en este caso nuestro proyecto puede estructurarse de manera modular para mejorar el mantenimiento y la escalabilidad la estructura que se plantea es la siguiente.
 
 
2. lógica de negocio
2.1 Modelo de negocio
package com.Sena.App.tienda.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name= "tbl_products")
@Data

public class Product {
    
    @Id
    private Long  IdProducto;
    private String  name;
    private String  brand;
    private boolean  expired;
     private float  price;
     
     @ManyToOne
     @JoinColumn(
             name = "id",
             referencedColumnName = "id_Local"
     
     )
     private Local Local;
   } 
2.2 repositorio de producto 
package com.Sena.App.tienda.repository;
import com.Sena.App.tienda.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LocalRepository extends JpaRepository<Local, Long > {
    }
2.3 Servicio del producto
package com.Sena.App.tienda.service;

import com.Sena.App.tienda.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sena.App.tienda.entity.Product;
@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    ProductRepository repository;
    
    @Override
    public List<Product> findAll(){
        return repository.findAll();
    }
    
} 
2.4  Controlador del producto 
package com.Sena.App.tienda.controller;

import com.Sena.App.tienda.service.ProductService;
import com.Sena.App.tienda.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Product")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping("/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }
}

3. Control de versiones 
Para este proyecto usamos la herramienda llamada gitHubo la cual usamos de desde la consola git bash y la dejamos publica para posibles aportes de la comunidad.




4. Buenas Prácticas de Codificación
Principios SOLID
Single Responsibility Principle:  Cada clase debe tener una sola responsabilidad.
Open/Closed Principle:  Las clases deben estar abiertas para extensión, pero cerradas para modificación.
Liskov Substitution Principle:  Las subclases deben ser sustituibles por sus clases base.
Interface Segregation Principle:  No obligar a implementar interfaces innecesarias.
Dependency Inversion Principle: Depender de abstracciones, no de concreciones.

5. patrones de diseño 
Para esta ocasión usamos patrones de diseño observer que definen las dependencias uno a muchos entre objectos de manera que cuando un objecto cambie su estado los otros objetos actualizan su estado automáticamente 

6.Pruebas unitarias.
package com.Sena.App.tienda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TiendaApplicationTests {

	@Test
	void contextLoads() {
	}

}



 
7. configuración del servidor 
server.port=8080
spring.sql.init.platform=mysql
spring.datasource.url=jdbc:mysql://localhost:3306/tienda_sena_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update

8. para este proyecto no se trabajo con seguridad 

9. configuración del servidor 
Vienen embebido con tomcat
server.port=8080
server.tomcat.max-threads=200
server.tomcat.uri-encoding=UTF-8


10. para este proyecto se instalo JDK de java 21 y JRE y el IDEA NETBEANS para la base de datos MySQL  XAMPP 
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.0</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.Sena.App</groupId>
	<artifactId>tienda</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>tienda</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>22</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	 <dependency>
	  <groupId>com.github.t1</groupId>
	  <artifactId>wunderbar.demo.product</artifactId>
	  <version>3.3</version>
	  <type>jar</type>
	 </dependency>
	 <dependency>
	  <groupId>jakarta.platform</groupId>
	  <artifactId>jakarta.jakartaee-api</artifactId>
	  <version>8.0.0</version>
	  <type>jar</type>
	 </dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>




