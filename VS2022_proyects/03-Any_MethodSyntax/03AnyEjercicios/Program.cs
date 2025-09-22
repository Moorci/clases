namespace _03AnyEjercicios
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Ejercicio 1
            int[] numeros = { 5, -3, 8, 0 };
            var numerosNegativos = numeros.Any(item => item < 0);

            //Ejercicio 2
            List<Libro> libros = new List<Libro>
                {
                new Libro { Titulo = "C#", Autor = "Juan" },
                new Libro { Titulo = "LINQ", Autor = "" }
                };
            var librosAutor = libros.Any(item => item.Autor == "");

            //Ejercicio 3
            List<Persona> personas = new List<Persona>
                {
                new Persona { Nombre = "Ana", Edad = 25 },
                new Persona { Nombre = "Luis", Edad = 16 }
                };
            var menorDeEdad = personas.Any(item => item.Edad < 18);

            //Ejercicio 4
            List<Producto> productos = new List<Producto>
            {
                new Producto { Nombre = "Teclado", Stock = 10 },
                new Producto { Nombre = "Ratón", Stock = 0 }
            };
            var stock = productos.Any(item => item.Stock == 0);

            //Ejercicio 5
            string[] cadenas = { "hola", "", "mundo" };
            var cadenaVacia = cadenas.Any(item => item.Equals(""));

            //Ejercicio 6
            List<Estudiante> estudiantes = new List<Estudiante>
            {
                new Estudiante { Nombre = "Carlos", Nota = 8.5 },
                new Estudiante { Nombre = "Lucía", Nota = 9.5 }
            };
            var notaMasQue9 = estudiantes.Any(item => item.Nota < 9);

            //Ejercicio 7
            List<Factura> facturas = new List<Factura>
            {
                new Factura { Id = 1, Pagada = true },
                new Factura { Id = 2, Pagada = false }
            };
            var facturasInpagas = facturas.Any(item => item.Pagada == false);

            //Ejercicio 8
            string[] palabras = { "sol", "estrella", "universo", "agua" };
            var vocal = palabras.Any(item => item.Contains(char.ToLower(item[0])));

            //Ejercicio 9
            int[] numeros2 = { 45, 102, 88, 150 };
            var numeroMas100 = numeros2.Any(item => item % 2 > 100);

            //Ejercicio 10
            List<Empleado> empleados = new List<Empleado>
            {
                new Empleado { Nombre = "Marta", Salario = 2800 },
                new Empleado { Nombre = "Jorge", Salario = 3200 }
            };
            var salarioEmple = empleados.Any(item => item.Salario > 3000);


        }
        class Libro { public string Titulo; public string Autor; }
        class Persona { public string Nombre; public int Edad; }
        class Producto { public string Nombre; public int Stock; }
        class Estudiante { public string Nombre; public double Nota; }
        class Factura { public int Id; public bool Pagada; }
        class Empleado { public string Nombre; public double Salario; }
    }
}

