Se crearon estas 5 Tablas para el proyecto

EMPRESA 
EMPRESA_PUNTO_DE_VENTA
PUNTO_DE_VENTA
USUARIO
USUARIO_EMPRESA

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
