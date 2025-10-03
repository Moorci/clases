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


        }

        class Libro { public string Titulo; public int Paginas; }
        class Persona { public string Nombre; public int Edad; }


    }
}
