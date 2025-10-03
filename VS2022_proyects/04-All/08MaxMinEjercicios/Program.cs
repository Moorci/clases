namespace _08MaxMinEjercicios
{
    internal class Program
    {
        class Persona
        {
            public string Nombre { get; set; }
            public int Edad { get; set; }
        }
        class Producto
        {
            public string Nombre { get; set; }
            public decimal Precio { get; set; }
        }


        static void Main(string[] args)
        {
            // Ejercicio 1
            int[] numeros = { 23, 45, 12, 67, 34, 89, 2 };
            int min1 = numeros.Min();
            int max1 = numeros.Max();
            bool hayMayor50 = numeros.Any(n => n > 50);

            // Ejercicio 2
            List<string> nombres = new List<string> { "Ana", "José", "María", "Pedro", "Luisa" };

            string nombreCorto = nombres.OrderBy(n => n.Length).First();
            string nombreLargo = nombres.OrderByDescending(n => n.Length).First();
            bool todosContienenA = nombres.All(n => n.ToLower().Contains('a'));

            // Ejercicio 3
            List<Persona> personas = new List<Persona>
            {
            new Persona { Nombre = "Carlos", Edad = 25 },
            new Persona { Nombre = "Lucía", Edad = 32 },
            new Persona { Nombre = "Pedro", Edad = 29 },
            new Persona { Nombre = "María", Edad = 45 }
            };

            Persona menor = personas.OrderBy(p => p.Edad).First();
            Persona mayor = personas.OrderByDescending(p => p.Edad).First();
            int mayores30 = personas.Count(p => p.Edad > 30);

            // Ejercicio 4
            double[] valores = { -3.5, 2.7, 0, 5.8, -1.2, 7.1 };
            double min4 = valores.Min();
            double max4 = valores.Max();
            bool hayNegativo = valores.Any(v => v < 0);

            // Ejercicio 5
            int[] numeros2 = { 10, 5, 15, 3, 20, 7 };

            int min5 = numeros2.Min();
            int max5 = numeros2.Max();
            var mayoresQueMin = numeros2.Where(n => n > min5).OrderBy(n => n).ToList();

            // Ejercicio 6
            List<Producto> productos = new List<Producto>
            {
            new Producto { Nombre = "Camiseta", Precio = 15.5m },
            new Producto { Nombre = "Pantalón", Precio = 35m },
            new Producto { Nombre = "Zapatos", Precio = 50m },
            new Producto { Nombre = "Calcetines", Precio = 5m }
            };

            decimal precioMin = productos.Min(p => p.Precio);
            decimal precioMax = productos.Max(p => p.Precio);
            bool hayMenor10 = productos.Any(p => p.Precio < 10);

            // Ejercicio 7
            int[] numeros3 = { 4, 7, 10, 3, 8, 2 };

            int min7 = numeros3.Min();
            int max7 = numeros3.Max();
            int pares = numeros3.Count(n => n % 2 == 0);

            // Ejercicio 8
            List<int> numeros4 = new List<int> { 1, 5, 10, 12, 7 };

            int min8 = numeros4.Min();
            int max8 = numeros4.Max();
            bool todosPositivos = numeros4.All(n => n > 0);

            // Ejercicio 9
            int[] valores2 = { 5, 8, 12, 5 };

            int min9 = valores2.Min();
            bool todosMayoresQueMin = valores.All(v => v > min9);

            // Ejercicio 10
            List<int> numeros5 = new List<int> { 4, 7, 10, 3, 8 };

            int menorPar = numeros5.Where(n => n % 2 == 0).Min();
        }
    }
}
