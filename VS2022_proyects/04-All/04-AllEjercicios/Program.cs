namespace _04_AllEjercicios
{
    internal class Program
    {
        static void Main(string[] args)
        {

            //Ejercicio 1
            int[] numeros = { 3, 5, 7, 9 };
            var todosPositivos = numeros.All(item => item > 0);

            //Ejercicio 2
            List<Libro> libros = new List<Libro>
            {
                new Libro { Titulo = "C#", Autor = "Juan" },
                new Libro { Titulo = "LINQ", Autor = "Ana" }
            };
            var todosAutor = libros.All(item => item.Autor != "");

            //Ejercicio 3
            List<Persona> personas = new List<Persona>
            {
                new Persona { Nombre = "Ana", Edad = 25 },
                new Persona { Nombre = "Luis", Edad = 19 }
            };
            var todosMayoresEdad = personas.All(item => item.Edad > 18);

            //Ejercicio 4
            List<Producto> productos = new List<Producto>
            {
                new Producto { Nombre = "Teclado", Stock = 10 },
                new Producto { Nombre = "Ratón", Stock = 5 }
            };
            var todosStock = productos.All(item => item.Stock > 0);

            //Ejercicio 5
            string[] cadenas = { "hola", "mundo", "LINQ" };
            var cadenaMasQue3 = cadenas.All(item => item.Length > 3);

            //Ejercicio 6
            List<Estudiante> estudiantes = new List<Estudiante>
            {
                new Estudiante { Nombre = "Carlos", Nota = 6.5 },
                new Estudiante { Nombre = "Lucía", Nota = 7.0 }
            };
            var aprobados = estudiantes.All(item => item.Nota > 5);



        }
        class Libro { public string Titulo; public string Autor; }
        class Persona { public string Nombre; public int Edad; }
        class Producto { public string Nombre; public int Stock; }
        class Estudiante { public string Nombre; public double Nota; }




    }
}
