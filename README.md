# TALLER 7: Aplicación Web Segura

## Desarrollo de una Aplicación Web Segura

Este proyecto tiene como objetivo desarrollar una aplicación web segura que cumple con los siguientes requerimientos:

1. **Acceso seguro desde el navegador**: La aplicación debe garantizar la autenticación, autorización e integridad de los usuarios que acceden a través de un navegador web.

2. **Comunicación segura entre servidores**: La aplicación debe constar de al menos dos servidores que se comunican entre sí. La comunicación entre estos servicios debe garantizar la autenticación, autorización y la integridad de los datos. Ningún servicio puede ser invocado por una entidad no autorizada.

## Requerimientos de Seguridad

Para cumplir con estos requerimientos, se implementarán las siguientes medidas de seguridad:

### Para el Acceso desde el Navegador

- Se utilizará un protocolo seguro (HTTPS) para garantizar la confidencialidad e integridad de los datos transmitidos entre el navegador y el servidor.

- La autenticación de usuarios se implementará utilizando tokens JWT (JSON Web Tokens) para garantizar la identidad de los usuarios.

- La autorización se gestionará a nivel de roles y permisos de usuario para controlar el acceso a las diferentes partes de la aplicación.

- Se aplicarán buenas prácticas de seguridad web, como la protección contra ataques XSS (Cross-Site Scripting) y CSRF (Cross-Site Request Forgery).

### Para la Comunicación entre Servidores

- Se utilizará un protocolo seguro (HTTPS) para garantizar la confidencialidad e integridad de los datos transmitidos entre los servicios.

- Se implementará un sistema de autenticación mutua basado en certificados para garantizar que solo los servidores autorizados puedan comunicarse entre sí.

- La autorización se gestionará mediante mecanismos de control de acceso a nivel de servicios para garantizar que solo los servicios autorizados puedan invocar otros servicios.

- Se aplicarán técnicas de validación y protección de datos para prevenir ataques de inyección y garantizar la integridad de los datos.

## Escalabilidad de la Arquitectura de Seguridad

Para incorporar nuevos servicios a la arquitectura de seguridad, se deben seguir estos pasos:

1. **Definir Requerimientos de Seguridad**: Antes de implementar un nuevo servicio, se deben definir claramente los requerimientos de seguridad, incluyendo autenticación, autorización y garantías de integridad.

2. **Configuración de Seguridad**: Cada nuevo servicio debe configurarse con los mecanismos de seguridad necesarios, como certificados SSL, autenticación de usuarios, control de acceso y validación de datos.

3. **Integración con el Sistema de Autorización**: Los nuevos servicios deben integrarse con el sistema de autorización existente para definir quién puede acceder a ellos y con qué permisos.

4. **Pruebas de Seguridad**: Antes de desplegar un nuevo servicio, se deben realizar pruebas exhaustivas de seguridad, incluyendo pruebas de penetración y evaluación de vulnerabilidades.

5. **Monitorización y Registro**: Una vez en producción, es esencial implementar un sistema de monitorización y registro para detectar y responder a eventos de seguridad inusuales.

## Buenas Prácticas

- Siempre utilizar protocolos seguros (HTTPS) para todas las comunicaciones.

- Implementar autenticación y autorización robustas.

- Validar y sanitizar todas las entradas de datos para prevenir ataques de inyección.

- Aplicar actualizaciones de seguridad regularmente.

## Cómo Ejecutar la Aplicación

Para ejecutar la aplicación, siga estos pasos:

1. Clone el repositorio desde GitHub.

    ```
    git clone https://github.com/SanRocks1220/AREP_Taller7.git
    ```

2. Asegúrese de tener Java y Maven instalado en su sistema.

3. Compile y ejecute los servidores `Server1.java` y `Server2.java`.

    ```
    mvn clean install
    ```

4. Acceda a la aplicación desde su navegador web utilizando la URL proporcionada.

    ```
    https://localhost:5000/hello        // Respuesta del Servidor 1
    https://localhost:5000/bonjour      // Respuesta del Servidor 2 a través del Servidor 1
    ```

![image](https://github.com/SanRocks1220/AREP_Taller7/assets/99696682/3259f76b-92f2-4067-ac1f-b0f9b6331b6a)
![image](https://github.com/SanRocks1220/AREP_Taller7/assets/99696682/5b68a65d-b9a7-4ff6-bae2-47ac2cf07e0b)


## AWS
![Modificación en el Código](https://github.com/SanRocks1220/AREP_Taller7/assets/99696682/fd06a0ff-2e1b-4354-bf6e-3103c100d66a)
Aquí se encuentra el video demostrando la funcionalidad en AWS:
- [Demostración de Funcionamiento en AWS](https://youtu.be/7J5FHVulL-E)

## Autor

- [Santiago A. Rocha](https://github.com/SanRocks1220)

## Colaboradores

- [Julia M. Mejía](https://github.com/juliamejia)
- [ChatGPT](https://chat.openai.com)
