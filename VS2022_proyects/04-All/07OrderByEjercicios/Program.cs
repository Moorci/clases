namespace _07OrderByEjercicios
{
    internal class Program
    {
        class Producto
        {
            public string Nombre { get; set; }
            public double Precio { get; set; }
        }
        class Empleado
        {
            public string Nombre { get; set; }
        }
        class Libro
        {
            public string Titulo { get; set; }
        }
        class Estudiante
        {
            public string Nombre { get; set; }
            public double Nota { get; set; }
        }



        static void Main(string[] args)
        {
            // 1. Ordenar nombres alfabéticamente y verificar si alguno contiene la letra "a"
            string[] nombres = { "Carlos", "Ana", "Luis", "Bea" };
            var nombresOrdenados = nombres.OrderBy(n => n);
            bool contieneA = nombres.Any(n => n.Contains("a"));

            // 2. Ordenar edades y contar cuántas son mayores de 30
            int[] edades = { 25, 40, 18, 35, 60 };
            var edadesOrdenadas = edades.OrderBy(e => e);
            int mayores30 = edades.Count(e => e > 30);

            // 3. Ordenar productos por precio y verificar si todos cuestan más de 10
            Producto[] productos = {
            new Producto { Nombre = "Pan", Precio = 1.5 },
            new Producto { Nombre = "Queso", Precio = 12 },
            new Producto { Nombre = "Vino", Precio = 20 }
            };

            var productosOrdenados = productos.OrderBy(p => p.Precio);
            bool todosMas10 = productos.All(p => p.Precio > 10);

            // 4. Ordenar ciudades por longitud de nombre y verificar si alguna contiene "Madrid"
            string[] ciudades = { "Bilbao", "Madrid", "Barcelona", "Sevilla" };

            var ciudadesOrdenadas = ciudades.OrderBy(c => c.Length);
            bool contieneMadrid = ciudades.Any(c => c.Contains("Madrid"));

            // 5. Ordenar números y verificar si todos son pares
            int[] numeros = { 2, 4, 6, 8, 10 };
            var numerosOrdenados = numeros.OrderBy(n => n);
            bool todosPares = numeros.All(n => n % 2 == 0);

            // 6. Ordenar empleados por nombre y contar cuántos tienen más de 5 letras
            Empleado[] empleados = {
            new Empleado { Nombre = "Ana" },
            new Empleado { Nombre = "Roberto" },
            new Empleado { Nombre = "Luis" }
            };

            var empleadosOrdenados = empleados.OrderBy(e => e.Nombre);
            int nombresLargos = empleados.Count(e => e.Nombre.Length > 5);

            // 7. Ordenar palabras alfabéticamente y verificar si alguna contiene la letra "z"
            string[] palabras = { "sol", "luz", "cielo", "estrella" };
            var palabrasOrdenadas = palabras.OrderBy(p => p);
            bool contieneZ = palabras.Any(p => p.Contains("z"));

            // 8. Ordenar temperaturas y verificar si todas son mayores que 0
            double[] temperaturas = { 15.5, 22.3, 0.0, 18.7 };
            var temperaturasOrdenadas = temperaturas.OrderBy(t => t);
            bool todasPositivas = temperaturas.All(t => t > 0);

            // 9. Ordenar libros por título y verificar si alguno contiene "C#"
            Libro[] libros = {
            new Libro { Titulo = "Aprende Java" },
            new Libro { Titulo = "C# Básico" },
            new Libro { Titulo = "Python Avanzado" }
            };

            var librosOrdenados = libros.OrderBy(l => l.Titulo);
            bool contieneCSharp = libros.Any(l => l.Titulo.Contains("C#"));

            // 10. Ordenar estudiantes por nota y contar cuántos tienen más de 8
            Estudiante[] estudiantes = {
            new Estudiante { Nombre = "Lucía", Nota = 9.2 },
            new Estudiante { Nombre = "Pedro", Nota = 7.5 },
            new Estudiante { Nombre = "María", Nota = 8.6 }
            };

            var estudiantesOrdenados = estudiantes.OrderByDescending(e => e.Nota);
            int sobresalientes = estudiantes.Count(e => e.Nota > 8);

        }
    }
}
