# BinaryTreeMasivian
Proyecto Arbol Binario, Prueba técnica desarrollador back-end, David Latorre.



1. A continuación los 2 endpoint y la descripción de los servicios:

	1.1. http://localhost:8080/BinaryTree/webresources/MasivianBinaryTree/createTree
		
		Servicio: POST
		Headers: Content-Type -> application/json
		Estructura Body: {"nodes":['números separados por ,']}
		Ejemplo Body: {"nodes":[1,2,5,4,9]}
		Resutlado: Arbol binario en formato JSON.
		Ejemplo resultado: {
							"root": {
								"value": 1,
								"rightChild": {
									"value": 2,
									"rightChild": {
										"value": 5,
										"leftChild": {
											"value": 4
										},
										"rightChild": {
											"value": 9
										}
									}
								}
							}
						}
		
		
	1.2. http://localhost:8080/BinaryTree/webresources/MasivianBinaryTree/lowestCommonAncestor
	
		Servicio: POST
		Headers: Content-Type -> application/json
		Estructura Body: {
							"tree":'arbol binario en formato json',
							"valueA":'primer valor a buscar',
							"valueB":'segundo valor a buscar'
											}
		Ejemplo Body: {
						"tree":{
							"root": {
								"value": 1,
								"rightChild": {
									"value": 2,
									"rightChild": {
										"value": 5,
										"leftChild": {
											"value": 4
										},
										"rightChild": {
											"value": 9
										}
									}
								}
							}
						},
						"valueA":4,
						"valueB":9
					}
		Resutlado: Ancestro mas cercano en formato JSON.
		Ejemplo resultado: {"Ancestro común más cercano: ": 5}

2. Especificaciones de entorno de desarrollo: 
	2.1. El proyecto se realizó en Netbeans 11.1.
	2.2. Java EE version: Java EE 7
	2.3. Servidor de aplicaciones: glassFish Server 5.1.0.
	2.4. JDK 1.8.
	2.5. Se utilizó maven para la administración de dependencias.

3. El código es en base a la información encontrada en https://www.baeldung.com/java-binary-tree

		
		
		
		
		