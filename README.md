Se crearon estas 5 Tablas para el proyecto

EMPRESA =  
 ID,  
 NIT, 
 NOMBRE_EMPRESA   

EMPRESA_PUNTO_DE_VENTA =
 ID_EMPRESA, 
 ID_PUNTO_DE_VENTA  

PUNTO_DE_VENTA
 ID
 DIRECCION
 NOMBRE  

USUARIO
 ID
 APELLIDO
 NOMBRE
 NUMERO_DOCUMENTO
 TELEFONO    

USUARIO_EMPRESA
 ID
 ID_EMPRESA
 ID_USUARIO 
 ROL  
 

Por postman se consumen los siguientes servicios

curl --location 'http://localhost:8080/api/usuarios/consultar/'

Respuesta= 
{
    "numeroDocumento": "10121314",
    "nombre": "Juan",
    "apellido": "Moreno",
    "telefono": "3117897898"
}

curl --location 'http://localhost:8080/api/usuariosEmpresa/consultarUsuariosConEmpresas'

Respuesta= 

[
    {
        "id": 1,
        "usuario": "Salvador",
        "empresa": {
            "nombre": "SIVAR",
            "nit": "12345667",
            "puntosVenta": []
        },
        "rol": "Admin"
    },
    {
        "id": 2,
        "usuario": "Salvador",
        "empresa": {
            "nombre": "SIVAR",
            "nit": "12345667",
            "puntosVenta": []
        },
        "rol": "Vendedor"
    }
]
