namespace Any01
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var numbers = new[] { 5, 9, 2, 12, 6 };
            //Chequea si algun numero es mas grande que 10
            /*bool mayorQue10 = numbers.Any(x => x >10);
            Console.WriteLine(mayorQue10);
            Console.ReadLine();*/

            var pets = new[]
            {
                new Pet(1, "Hannibal", PetType.Fish, 1.1f),
                new Pet(2, "Anthony", PetType.Cat, 2f),
                new Pet(3, "Ed", PetType.Cat, 0.7f),
                new Pet(4, "Taiga", PetType.Dog, 35f),
                new Pet(5, "Rex", PetType.Dog, 40f),
                new Pet(6, "Lucky", PetType.Dog, 5f),
                new Pet(7, "Storm", PetType.Cat, 0.9f),
                new Pet(8, "Nyan", PetType.Cat, 2.2f)
            };

            //algun pet que se llame bruce
            var isAnyPetNameBruce = pets.Any(item => item.Name == "Bruce");
            Console.WriteLine(isAnyPetNameBruce);

            //algun pet de tipo fish
            var isAnyFish = pets.Any(items => items.PetType == PetType.Fish);
            Console.WriteLine(isAnyFish);

            //algun pet que no tenga mas de 6 letras y el id sea igual al numero
            var two = pets.Any(items => items.Name.Length > 6 && items.Id % 2 == 0);
            Console.WriteLine(two);

            //verificar si esta vacio o no
            var isnotEmpty = pets.Any();
            Console.WriteLine(isnotEmpty);

            //algun gato que pese mas de 2 kilos
            var three = pets.Any(items => items.PetType == PetType.Cat &&  items.Weight > 2);
            Console.WriteLine(three);

            var nombresValidos = !pets.Any(items => char.IsLower(items.Name[0]) || items.Name.Length < 2 || items.Name.Length > 25);
            Console.WriteLine(nombresValidos);

            Console.ReadLine();
        }
    }
}
