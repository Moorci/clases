namespace _06ContainsEjercicios
{
    internal class Program
    {
        class Persona { public string Nombre; public int Edad; }
        class Estudiante { public string Nombre; public double Nota; }
        class Empleado { public string Nombre; public double Salario; }


        static void Main(string[] args)
        {
            // 1: ¿El array contiene el número 10?
            int[] numeros = { 5, 10, 15, 20 };
            bool contiene10 = numeros.Contains(10);

            // 2: ¿La lista de títulos contiene "LINQ"?
            List<string> titulos = new List<string> { "C#", "LINQ", "ASP.NET" };
            bool contieneLINQ = titulos.Contains("LINQ");

            // 3: ¿Hay alguna persona llamada "Luis"?
            List<Persona> personas = new List<Persona>
            {
            new Persona { Nombre = "Ana", Edad = 25 },
            new Persona { Nombre = "Luis", Edad = 30 }
            };

            bool hayLuis = personas.Any(p => p.Nombre == "Luis");

            // 4: ¿La lista de productos contiene "Ratón"?
            List<string> productos = new List<string> { "Teclado", "Monitor", "Ratón" };
            bool contieneRaton = productos.Contains("Ratón");

            // 5: ¿El array de caracteres contiene la letra 'A'?
            char[] letras = { 'B', 'C', 'A', 'D' };
            bool contieneA = letras.Contains('A');

            // 6: ¿Algún estudiante se llama "Lucía"
            List<Estudiante> estudiantes = new List<Estudiante>
            {
            new Estudiante { Nombre = "Carlos", Nota = 7.5 },
            new Estudiante { Nombre = "Lucía", Nota = 9.0 }
            };

            bool hayLucia = estudiantes.Any(e => e.Nombre == "Lucía");

            // 7: ¿La lista de IDs contiene el número 3?
            List<int> ids = new List<int> { 1, 2, 3, 4 };
            bool contiene3 = ids.Contains(3);

            // 8: ¿Alguna palabra contiene la subcadena "net"?
            string[] palabras = { "internet", "red", "conexión", "netflix" };

            bool contieneNet = palabras.Any(p => p.Contains("net"));

            // 9: ¿La lista de números contiene el valor 100?
            List<int> valores = new List<int> { 50, 75, 100, 125 };
            bool contiene100 = valores.Contains(100);

            // 10: ¿Algún empleado se llama "Jorge"?
            List<Empleado> empleados = new List<Empleado>
            {
            new Empleado { Nombre = "Marta", Salario = 1200 },
            new Empleado { Nombre = "Jorge", Salario = 1500 }
            };

            bool hayJorge = empleados.Any(e => e.Nombre == "Jorge");

        }
    }
}
