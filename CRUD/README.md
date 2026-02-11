# ISP: Interface Segregation Principle
## Principio de Segregación de Interfaces

**Definición:** Los clientes no deben depender de interfaces que no usan. Prefiere muchas interfaces específicas sobre una interfaz general.

---

## 📁 Estructura del Proyecto

```
CRUD/
├── con_isp/           ✅ Ejemplo CORRECTO (cumple ISP)
│   ├── Usuario.java
│   ├── CrearRepositorio.java
│   ├── LeerRepositorio.java
│   ├── ActualizarRepositorio.java
│   ├── EliminarRepositorio.java
│   ├── RepositorioEnMemoria.java
│   ├── ServicioAdmin.java
│   ├── ServicioConsulta.java
│   └── Demo.java
│
├── sin_isp/           ❌ Ejemplo INCORRECTO (viola ISP)
│   ├── Usuario.java
│   ├── Repositorio.java        (interfaz monolítica)
│   ├── RepositorioEnMemoria.java
│   ├── ServicioAdmin.java
│   ├── ServicioLectura.java
│   └── Demo.java
│
└── MainComparacion.java        (ejecuta ambas demos)
```

---

## 🚀 Cómo Ejecutar

### Compilar
```powershell
cd "C:\Users\jcruz\Documentos\Universidad\VI Semestre\Arquitectura Software\arquitectura-software-grupo4\CRUD"
javac -d . con_isp\*.java sin_isp\*.java MainComparacion.java
```

### Ejecutar
```powershell
java MainComparacion
```

### Salida Esperada
```
--- Ejemplo CON ISP (buena práctica) ---
Lista inicial:
Usuario{id='1', nombre='Juana'}
Usuario{id='2', nombre='Carlos'}
(ServicioConsulta depende solo de LeerRepositorio)

--- Ejemplo SIN ISP (mala práctica) ---
Lista inicial:
Usuario{id='A1', nombre='Ana'}
Usuario{id='B2', nombre='Beto'}
(ServicioLectura depende de Repositorio monolítico)
```

---

## 🎤 GUION DE EXPOSICIÓN (6 PERSONAS)

### **PERSONA 1: Introducción (2 minutos)**
**Tema:** ¿Qué es ISP y por qué importa?

_Diapositiva 1: "ISP - Interface Segregation Principle"_

> Hola grupo, soy [NOMBRE] y hoy presentamos el **Principio de Segregación de Interfaces (ISP)**.
> 
> **Definición simple:** Los clientes (servicios) no deben depender de interfaces que no usan.
> 
> Imaginen que van a un restaurante y el menú tiene platos para alérgicos, veganos, carnívoros, sin gluten, etc.
> Si el mesero te muestra TODO el menú aunque solo eres vegano, eso es confuso e innecesario.
> 
> **ISP dice:** Crea menús específicos. Si eres vegano, recibes solo opciones veganas.
> 
> En programación es igual: si un servicio solo necesita LEER datos, no debe recibir una interfaz que le permita CREAR, ACTUALIZAR o ELIMINAR.
> 
> Esto reduce acoplamiento, mejora claridad y hace el código más mantenible.

---

### **PERSONA 2: El Problema (2 minutos)**
**Tema:** Ejemplo SIN ISP (mala práctica)

_Diapositiva 2: "Sin ISP - Problema"_

> Yo soy [NOMBRE] y voy a mostrar el **problema** de no aplicar ISP.
> 
> Miren el código en `sin_isp/`:
> - Tenemos una interfaz llamada `Repositorio` que tiene **todos** los métodos CRUD:
>   - crear()
>   - obtenerPorId()
>   - listar()
>   - actualizar()
>   - eliminar()
> 
> Ahora, el servicio `ServicioLectura` **solo necesita leer** (listar, obtenerPorId).
> Pero recibe la interfaz **COMPLETA** de Repositorio.
> 
> ¿El problema?
> - `ServicioLectura` depende de métodos que NO usa (actualizar, eliminar).
> - Si alguien cambia `actualizar()`, afecta a `ServicioLectura` aunque no lo use.
> - El código es confuso: ¿qué operaciones puede realmente hacer este servicio?
> 
> Esta es una **interfaz gorda** y violaremos ISP.

---

### **PERSONA 3: La Solución (2 minutos)**
**Tema:** Ejemplo CON ISP (buena práctica)

_Diapositiva 3: "Con ISP - Solución"_

> Hola, soy [NOMBRE]. Ahora les muestro la **solución** aplicando ISP.
> 
> En `con_isp/`, segregamos la interfaz monolítica en **4 interfaces específicas**:
> 
> 1. **CrearRepositorio** - solo `crear(Usuario)`
> 2. **LeerRepositorio** - solo `obtenerPorId()` y `listar()`
> 3. **ActualizarRepositorio** - solo `actualizar(Usuario)`
> 4. **EliminarRepositorio** - solo `eliminar(String id)`
> 
> Cada servicio recibe **SOLO lo que necesita**:
> - `ServicioConsulta` recibe `LeerRepositorio` (interfaz con 2 métodos).
> - `ServicioAdmin` recibe `CrearRepositorio`, `ActualizarRepositorio`, `EliminarRepositorio` (3 interfaces).
> 
> **Ventajas:**
> - Bajo acoplamiento: cambios en lectura no afectan a admin.
> - Claridad: el código documenta a sí mismo qué puede hacer cada servicio.
> - Fácil testing: podemos mockear cada interfaz por separado.
> - Mayor seguridad: `ServicioConsulta` no puede (ni debe) modificar datos.

---

### **PERSONA 4: Comparación Técnica (2 minutos)**
**Tema:** Diferencias clave en la implementación

_Diapositiva 4: "Comparación Código: Sin ISP vs Con ISP"_

> Soy [NOMBRE]. Voy a mostrar las **diferencias clave** en código.
> 
> **SIN ISP:**
> ```java
> public class ServicioLectura {
>     private final Repositorio repositorio;  // Recibe interfaz MONOLÍTICA
>     // Solo usa: repositorio.obtenerPorId() y repositorio.listar()
>     // PERO también tiene acceso a: crear(), actualizar(), eliminar()
> }
> ```
> 
> **CON ISP:**
> ```java
> public class ServicioConsulta {
>     private final LeerRepositorio lector;  // Recibe interfaz SEGREGADA
>     // Solo puede usar: lector.obtenerPorId() y lector.listar()
>     // NO tiene acceso a: crear(), actualizar(), eliminar()
> }
> ```
> 
> **Diferencia clave:** En con_isp, el compilador garantiza que `ServicioConsulta` no puede
> modificar datos. Es una garantía a nivel de tipo, no solo de intención.
> 
> La implementación `RepositorioEnMemoria` es idéntica en ambos casos, pero las interfaces
> difieren radicalmente en su segregación.

---

### **PERSONA 5: Ejecución y Análisis (2 minutos)**
**Tema:** Ejecutar el programa y analizar la salida

_Diapositiva 5: "Ejecutar y Observar"_

> Yo soy [NOMBRE]. Vamos a **ejecutar el programa** y analizar qué sucede.
> 
> Comando:
> ```
> javac -d . con_isp\*.java sin_isp\*.java MainComparacion.java
> java MainComparacion
> ```
> 
> **Salida:**
> - Primero ve la demo `con_isp` (ISP aplicado correctamente).
> - Luego ve la demo `sin_isp` (ISP violado).
> 
> **Funcionalmente son idénticas:** ambas crean usuarios y los listan.
> 
> **Pero arquitectónicamente son muy diferentes:**
> - `con_isp`: servicios segregados, bajo acoplamiento.
> - `sin_isp`: servicios acoplados a una interfaz gorda.
> 
> En un sistema pequeño la diferencia parece mínima. Pero en proyectos grandes con
> 100+ servicios, ISP previene problemas de mantenibilidad y entiende de cambios.

---

### **PERSONA 6: Conclusión y Beneficios (2 minutos)**
**Tema:** Resumen, beneficios finales y recomendaciones

_Diapositiva 6: "Beneficios y Conclusión"_

> Soy [NOMBRE], cierro la presentación. Aquí están los **beneficios clave del ISP:**
> 
> ✅ **Bajo acoplamiento:** Cambios en una operación no rompen otros servicios.
> 
> ✅ **Claridad y documentación:** El código documenta a sí mismo qué puede hacer cada cliente.
> 
> ✅ **Testing simplificado:** Puedes mockear interfaces pequeñas y específicas.
> 
> ✅ **Seguridad:** Fuerza de tipo: el compilador garantiza que no llames métodos prohibidos.
> 
> ✅ **Flexibilidad:** Fácil agregar nuevas operaciones sin afectar servicios existentes.
> 
> **Regla de oro del ISP:**
> > "Muchas interfaces específicas son mejores que una interfaz general."
> 
> **Recomendación:**
> - Cuando crees una interfaz, pregúntate: ¿todos los clientes usan todos los métodos?
> - Si la respuesta es NO, segregaaa.
> - Mejor tener 5 interfaces pequeñas que 1 interfaz gorda.
> 
> Gracias. ¿Preguntas?

---

## 📝 Notas Adicionales para el Grupo

### Cómo Repartir Presentación
1. **Persona 1:** Lee la introducción (2 min).
2. **Persona 2:** Muestra `sin_isp/` (2 min).
3. **Persona 3:** Muestra `con_isp/` (2 min).
4. **Persona 4:** Explica diferencias técnicas (2 min).
5. **Persona 5:** Ejecuta y analiza (2 min).
6. **Persona 6:** Cierra con conclusiones (2 min).

**Total: ~12 minutos de presentación.**

### Preguntas Comunes para Anticipar
- **P:** ¿No es complicado crear tantas interfaces?
- **R:** Inicialmente sí, pero el beneficio a largo plazo es enorme.

- **P:** ¿Cuándo aplicar ISP?
- **R:** En sistemas que esperan cambio frecuente o tienen múltiples clientes. En scripts pequeños, quizás no sea necesario.

- **P:** ¿Cómo sé si mi interfaz es "demasiada gorda"?
- **R:** Si un cliente no usa todos los métodos, probablemente sea gorda. Refactoriza.

---

## 🔗 Referencias
- Clean Code: A Handbook of Agile Software Craftsmanship (Robert C. Martin)
- SOLID Principles in Java

---

**Preparado para el grupo de Arquitectura Software - VI Semestre**
