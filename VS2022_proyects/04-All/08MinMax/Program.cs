namespace _08MinMax
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var words = new[] { "aaa", "bb", "c", "dddd" };
            var aaaa = words.Min(x => x.Length);
            Console.WriteLine(aaaa);
            Console.WriteLine(bbbb(words));

            //  Ejercicio 1
            var numbers2 = new[] { 3, 2, 2, 4, 4, 0 };
            Console.WriteLine(CountOfLarguestNumber(numbers2));

            //Using LINQ, refactor the CountOfDogsOfTheOwnerWithMostDogs method.
            var Pets = new[]
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

            var owners = new List<Person>
            {
             new Person(1, "John", new [] {
                   Pets[0],
                   Pets[1],
                   Pets[2]
               }),
               new Person(2, "Jack", new [] {
                   Pets[2]
               }),
               new Person(3, "Stephanie", new [] {
                   Pets[3],  //Taiga
                   Pets[4]   //Rex 
               })
            };

            Console.WriteLine(CountOfDogsOfTheOwnerWithMostDogs(Pets, owners));
            Console.ReadLine();
        }

        public static int? bbbb(IEnumerable<string> words)
        {
            if(words == null || !words.Any())
            {
                return null;
            }
            return words.Min(x => x.Length);
        }

        public static int? CountOfLarguestNumber(IEnumerable<int> numbers)
        {
            return numbers.Count(x => x == numbers.Max());
        }

        public static int? CountOfDogsOfTheOwnerWithMostDogs(IEnumerable<Pet> Pets, IEnumerable<Person> owners)
        {
            return owners.Max(owner => owner.Pets.Count(pet => pet.PetType==PetType.Dog));
        }
    }
}
