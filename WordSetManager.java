package wordsearch;
import java.util.Random;

public class WordSetManager {

    public static WordSet getRandomWordSet(int numWords)
    {
        String[] titles = {"Fruits", "Vegetables", "League of Legends", "Movies", "Nintendo", "Anime"};
        int rnd = new Random().nextInt(titles.length);

        String randomTitle = titles[rnd];
        return createWordSet(randomTitle, numWords);
    }


    private static WordSet createWordSet(String title, int numWords)
    {
        String[] wordList = new String[numWords];
        String[] selectedList;

        if (title.equals("Fruits"))
        {
            selectedList = new String[]{"Apple","Apricot","Artichoke","Pear","Avocado","Banana","Bean","Beet","BellPepper","Melon","Blackberry","Blueberry","Cantaloupe","Cherry","Coconut","Corn","Cranberry","Cucumber","Date","Plums","Eggplant","Endive","Fig","Gooseberry","Grapefruit","Grape","Guava","Honeydew","Kiwifruit","Kumquat","Lemon","Lime","Lychee","Mandarin","Mango","Mulberry","Nectarine","Orange","Papaya","PassionFruit","Peach","Pineapple","Pomegranate","Prune","Raisin","Raspberry","Rhubarb","Strawberry","Tangerine","Tomato","Watermelon"};
            shuffleArray(selectedList);
            for (int i = 0; i < numWords; i++)
                wordList[i] = selectedList[i].toUpperCase();
        }
        else if (title.equals("Vegetables"))
        {
            selectedList = new String[]{"Amaranth","Artichoke","Asparagus","Avocado","Beetroot","Bitterleaf","BlackeyedPea","Gourd","Broccoli","BrusselSprout","Squash","Cabbage","Carrot","Cauliflower","Celery","ChickPea","Chive","Cilantro","Cucumber","Pea","Eggplant","Ginger","Greenbean","KidneyBean","Leek","Lemon","Lentil","Lettuce","LimaBean","Lime","Mushroom","Spinach","Olive","Onion","Parsley","Parsnip","Pickle","Radish","Soybean","Sprout","Taro","Tomato","Turnip","Watercress","Zucchini"};
            shuffleArray(selectedList);
            for (int i = 0; i < numWords; i++)
                wordList[i] = selectedList[i].toUpperCase();
        }
        else if (title.equals("League of Legends"))
        {
            selectedList = new String[]{"Aatrox","Ahri","Akali","Alistar","Amumu","Anivia","Annie","Ashe","Azir","Blitzcrank","Brand","Braum","Caitlyn","Cassiopeia","ChoGath","Corki","Darius","Diana","DrMundo","Draven","Elise","Evelynn","Ezreal","Fiddlesticks","Fiora","Fizz","Galio","Gangplank","Garen","Gnar","Gragas","Graves","Hecarim","Heimerdinger","Irelia","Janna","JarvanIV","Jax","Jayce","Jinx","Kalista","Karma","Karthus","Kassadin","Katarina","Kayle","Kennen","KhaZix","KogMaw","LeBlanc","LeeSin","Leona","Lissandra","Lucian","Lulu","Lux","Malphite","Malzahar","Maokai","MasterYi","MissFortune","Mordekaiser","Morgana","Nami","Nasus","Nautilus","Nidalee","Nocturne","Nunu","Olaf","Orianna","Pantheon","Poppy","Quinn","Rammus","RekSai","Renekton","Rengar","Riven","Rumble","Ryze","Sejuani","Shaco","Shen","Shyvana","Singed","Sion","Sivir","Skarner","Sona","Soraka","Swain","Syndra","Talon","Taric","Teemo","Thresh","Tristana","Trundle","Tryndamere","TwistedFate","Twitch","Udyr","Urgot","Varus","Vayne","Veigar","VelKoz","Viktor","Vladimir","Volibear","Warwick","Wukong","Xerath","Xin Zhao","Yasuo","Yorick","Zac","Zed","Ziggs","Zilean","Zyra","Toxic","SoloQ","Ranked","TSM","Gank","Top","Mid","Bot","Jungle","Supp","ADC","TopGap","JungleDiff","Meta","visionscore","ward","FFIS","Summoner","Windwall","flash","ignite","barrier","redbuff","bluebuff","raptors","krugs","scuttlebug","faker","swordart","hardstuck","iron","bronze","silver","gold","platinum","diamond","challenger"};
            shuffleArray(selectedList);
            for (int i = 0; i < numWords; i++)
                wordList[i] = selectedList[i].toUpperCase();
        }
        else if (title.equals("Movies"))
        {
            selectedList = new String[]{"StarWar","Avengers","Avatar","BlackPanther","InfinityWar","Titanic","JurassicPark","Incredibles","LionKing","DarkKnight","BeautyandBeast","FindingNeemo","Frozen","Shrek","ToyStory","HungerGames","SpiderMan","Jumanji","Transformers","HarryPotter","LordofTheRings","DespicableMe","JungleBook","Deadpool","InsideOut","Aladdin","FastAndFurious","Zootopia","Minions","Joker","ForrestGump","TheHobbit","Twilight","Up","Inception","Narnia","MonstersInc","Superman","FindingDory","MenInBlack","Thor","Venom","IceAge","OverTheHedge","Bambi","Grease","MaryPoppins","SoundOfMusic","Hamilton","JurassicWorld","Godfather"};
            shuffleArray(selectedList);
            for (int i = 0; i < numWords; i++)
                wordList[i] = selectedList[i].toUpperCase();
        }
        else if (title.equals("Nintendo"))
        {
            selectedList = new String[]{"link","zelda","ganon","darkLink","majora","zant","epona","dekuTree","impa","kaeporaGaebora","midna","navi","skullKid","dampe","mario","luigi","peach","daisy","toad","yoshi","donkeyKong","diddyKong","rosalina","toadette","birdo","bowser","wario","waluigi","koopaling","boo","goomba","pikachu","charizard","snorlax","charmander","ditto","squirtle","mewtwo","jigglypuff","mrMime","magikarp","samus","olimar","smashBros","starfox","eGadd","tomNook"};
            shuffleArray(selectedList);
            for (int i = 0; i < numWords; i++)
                wordList[i] = selectedList[i].toUpperCase();
        }
        else if (title.equals("Anime"))
        {
            selectedList = new String[]{"AttackOnTitan","Acadamia","HunterXHunter","SteinsGate","OnePiece","MyHero","Kakegurui","FruitsBasket","CodeGeass","Castlevania","Naruto","SwordArt","DemonSlayer","KillLaKill","YuriOnIce","Clannad","DragonBallZ","Jojo","Deku","PsychoPass","DeathNote","Fullmetal","OnePunch","TokyGhoul","Toradora","FairyTale","BlackClover","MobPsycho","Bleach","CowboyBepop","DeathParade","SoulEater","Fanservice","Nani","Kawii","Killua","Light","Saitama","Elric","Levi","Lelouch","Todoroki","Gon","Midoriya","Mikasa","Hisoka","Goku","Kurapika","Erza","Bakugo"};
            shuffleArray(selectedList);
            for (int i = 0; i < numWords; i++)
                wordList[i] = selectedList[i].toUpperCase();
        }



        return new WordSet(title, wordList);
    }

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(String[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
