namespace _05CountEjercicios
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //  Ejercicio 1
            int[] numeros = { 2, 3, 4, 5, 6 };
            var numerosPares = numeros.Count(item => item % 2 == 0);

            //  Ejercicio 2

            List<Libro> libros = new List<Libro>
            {
                new Libro { Titulo = "C#", Paginas = 250 },
                new Libro { Titulo = "LINQ", Paginas = 320 },
                new Libro { Titulo = "ASP.NET", Paginas = 400 }
            };

            var librosmasde300 = libros.Count(item => item.Paginas >=300);

            //  Ejercicio 3

            List<Persona> personas = new List<Persona>
            {
                new Persona { Nombre = "Ana", Edad = 25 },
                new Persona { Nombre = "Luis", Edad = 16 },
                new Persona { Nombre = "Marta", Edad = 17 }
            };

            var personasPares = personas.Count(item => item.Edad < 18);

            //  Ejercicio 4
            List<Producto> productos = new List<Producto>
            {
            new Producto { Nombre = "Teclado", Stock = 10 },
            new Producto { Nombre = "Ratón", Stock = 0 },
            new Producto { Nombre = "Monitor", Stock = 0 }
            };

            int agotados = productos.Count(p => p.Stock == 0);

            // Ejercicio 5

            string[] cadenas = { "hola", "mundo", "programación", "LINQ" };

            int largas = cadenas.Count(c => c.Length > 5);

            // Ejercicio 6
            List<Estudiante> estudiantes = new List<Estudiante>
            {
            new Estudiante { Nombre = "Carlos", Nota = 7.5 },
            new Estudiante { Nombre = "Lucía", Nota = 9.0 },
            new Estudiante { Nombre = "Pedro", Nota = 8.5 }
            };

            int sobresalientes = estudiantes.Count(e => e.Nota > 8);

            // Ejercicio 7

            List<Factura> facturas = new List<Factura>
            {
            new Factura { Id = 1, Pagada = true },
            new Factura { Id = 2, Pagada = false },
            new Factura { Id = 3, Pagada = false }
            };

            int impagas = facturas.Count(f => !f.Pagada);

            // Ejercicio 8
            string[] palabras = { "sol", "estrella", "universo", "agua", "idea" };
            int vocales = palabras.Count(p => "aeiouAEIOU".Contains(p[0]));

            // Ejercicio 9
            int[] numeros2 = { 45, 102, 88, 150, 200 };

            int mayores100 = numeros2.Count(n => n > 100);

            // Ejercicio 10
            List<Empleado> empleados = new List<Empleado>
            {
            new Empleado { Nombre = "Marta", Salario = 1100 },
            new Empleado { Nombre = "Jorge", Salario = 1500 },
            new Empleado { Nombre = "Laura", Salario = 1000 }
            };

            int bajosSalario = empleados.Count(e => e.Salario < 1200);


        }

        class Libro { public string Titulo; public int Paginas; }
        class Persona { public string Nombre; public int Edad; }
        class Producto { public string Nombre; public int Stock; }
        class Estudiante { public string Nombre; public double Nota; }
        class Factura { public int Id; public bool Pagada; }
        class Empleado { public string Nombre; public double Salario; }





    }
}
