namespace _07OrderBy
{
    internal class Program
    {
        static void Main(string[] args)
        {
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
            var petsOrderedByName = pets.OrderBy(pet => pet.Name);

            foreach (var pet in petsOrderedByName) { 
                Console.WriteLine(pet.Id + " " + pet.Name); 
            }

            //  Ordenamos por tipo y por nombre
            var petsOrderedByTypeThenName = pets.OrderBy(pet => pet.PetType).ThenBy(pet => pet.Name);
            foreach (var pet in petsOrderedByTypeThenName)
            {
                Console.WriteLine(pet.PetType + " " + pet.Name);
            }

            /*
                Using LINQ, implement the FirstEvenThenOddDescending method, which orders numbers like this:
                    first, the even numbers
                    then, the odd numbers
                Then the numbers should be ordered descending.
                For example, for numbers {1,2,3,4,5,6,7} the result should be: {6,4,2,7,5,3,1}.
             */

            var numbers2 = new[] { 1, 2, 3, 4, 5, 6, 7 };
            var numbers2a = numbers2.OrderBy(item => item % 2 != 0).ThenByDescending(item => item);
            var numbers2aJoin = string.Join(", ", numbers2a);
            Console.WriteLine(numbers2aJoin);
            Console.ReadLine();
        }
    }
}
