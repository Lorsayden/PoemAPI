package app.controllers;

import app.dao.impl.PoemDAO;
import app.dtos.PoemDTO;
import app.entities.Author;
import app.entities.Poem;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoemController
{


    static Author author1 = new Author("Rikke & ChatGPT");
    static Author author2 = new Author("Lasse & ChatGPT");
    static Author author3 = new Author("ChatGPT");

    private static List<Poem> poems = new ArrayList<>(Arrays.asList(
            new Poem("The Codeborn Sage", "Epic", "Upon the land where circuits hum,\n" +
                    "A scholar rose, both wise and young.\n" +
                    "His locks, like fire, in crimson flared,\n" +
                    "Behind his glasses, keen eyes stared.\n" +
                    "\n" +
                    "With books and screens his fate was tied,\n" +
                    "A seeker’s heart, with code his guide.\n" +
                    "From arcane runes of ones and naughts,\n" +
                    "He wove his spells, his logic wrought.\n" +
                    "\n" +
                    "Oh, see him now! In candle’s light,\n" +
                    "He conquers loops in endless night.\n" +
                    "With mighty keystrokes, swift and true,\n" +
                    "He bends machines to paths anew.\n" +
                    "\n" +
                    "But lo! A bug, dark foe unseen,\n" +
                    "With silent steps it lurks between\n" +
                    "His logic gates—its treachery\n" +
                    "Now tests his wit and mastery.\n" +
                    "\n" +
                    "With furrowed brow, the hero thinks,\n" +
                    "Through lines of code his focus sinks.\n" +
                    "A flash! A spark! His mind ignites—\n" +
                    "The answer clear as dawn’s first light!\n" +
                    "\n" +
                    "With fingers fleet, he strikes once more,\n" +
                    "And in an instant—error no more!\n" +
                    "The beast is tamed, the program flows,\n" +
                    "A chorus sings, the circuit glows.\n" +
                    "\n" +
                    "Thus grows the sage, his legend born,\n" +
                    "Through midnight toil, through mind reborn.\n" +
                    "For in the world of code untamed,\n" +
                    "The brightest stars burn through the frame.", author1),
            new Poem("The Beard of Code Eternal", "Epic", "In ages past, when knowledge slept,\n" +
                    "A child was born where bright minds wept.\n" +
                    "With fire-red locks and vision keen,\n" +
                    "He saw the world in lines unseen.\n" +
                    "\n" +
                    "Yet one great gift would mark his fate,\n" +
                    "A power vast, a force innate.\n" +
                    "For as he learned, as wisdom grew,\n" +
                    "Upon his chin, the legend too!\n" +
                    "\n" +
                    "A beard took root—a mighty sight,\n" +
                    "A flowing mane of crimson light.\n" +
                    "It shimmered bright with arcane glow,\n" +
                    "As knowledge deep began to flow.\n" +
                    "\n" +
                    "Through loops and scripts, through lines so vast,\n" +
                    "He tamed the code, he bound it fast.\n" +
                    "Yet darkness lurked, a specter bold,\n" +
                    "A hacker vile with heart so cold.\n" +
                    "\n" +
                    "This shadowed fiend, in depths concealed,\n" +
                    "Released a curse, a bug revealed.\n" +
                    "It writhed in bits, it tore through space,\n" +
                    "It threatened all the cyber-place.\n" +
                    "\n" +
                    "But lo! Our hero, beard aflame,\n" +
                    "Rose high to meet this wicked game.\n" +
                    "His whiskers flared with logic pure,\n" +
                    "Their fibers humming, strong and sure.\n" +
                    "\n" +
                    "With hands of speed, he forged his spell,\n" +
                    "A script so vast, no foe could quell.\n" +
                    "His beard, alive, its power surged,\n" +
                    "Through tangled code, the beast was purged!\n" +
                    "\n" +
                    "And when the storm at last was done,\n" +
                    "The servers sang, the code had won.\n" +
                    "A monument in bytes was made,\n" +
                    "To honor him—whose beard ne'er swayed.\n" +
                    "\n" +
                    "Thus bards shall sing in lines well-weaved,\n" +
                    "Of he whose whiskers still achieved.\n" +
                    "A legend vast, a truth well-spun,\n" +
                    "The Beard of Code—forever won!", author1),
            new Poem("Candy, The Golden Heart", "Epic", "Sing, O Muse, of the noble hound,\n" +
                    "Whose golden light did long abound.\n" +
                    "Through thirteen years, so brave, so true,\n" +
                    "She walked the path the fateful knew.\n" +
                    "\n" +
                    "Her name was Candy, soft yet strong,\n" +
                    "A guardian kind, where hearts belong.\n" +
                    "With eyes so warm, with step so light,\n" +
                    "She led through darkness into sight.\n" +
                    "\n" +
                    "No weary soul was left behind,\n" +
                    "For Candy served with heart aligned.\n" +
                    "Through rain and sun, through dawn and night,\n" +
                    "She bore the torch, she was the light.\n" +
                    "\n" +
                    "But time is cruel to those who give,\n" +
                    "Even legends cannot live\n" +
                    "Beyond the call, beyond the veil,\n" +
                    "Where heroes rest and journeys pale.\n" +
                    "\n" +
                    "The final breath, the slowing beat,\n" +
                    "The faithful paws, now still, now sweet.\n" +
                    "Yet lo! The wind now softly sighs—\n" +
                    "Her spirit runs beneath the skies!\n" +
                    "\n" +
                    "Through golden fields, through endless space,\n" +
                    "She sprints in time’s embrace.\n" +
                    "Her duty done, her love remains,\n" +
                    "Forever bound, through joy and pain.\n" +
                    "\n" +
                    "And those who knew her name so bright,\n" +
                    "Shall feel her warmth in dream and night.\n" +
                    "For Candy’s soul was made of gold,\n" +
                    "And legends, thus, are never old.", author1),
            new Poem("The Shattered Crown (On America’s Chaos)", "Epic", "O land once bright, now dimmed with strife,\n" +
                    "Where echoes clash in endless life.\n" +
                    "A kingdom vast, with banners torn,\n" +
                    "Once hailed in pride, now lost, forlorn.\n" +
                    "\n" +
                    "The halls of power quake with lies,\n" +
                    "Where gold and greed have veiled the skies.\n" +
                    "The people rage, yet voices break,\n" +
                    "As shadows rise and strongholds shake.\n" +
                    "\n" +
                    "The lords once sworn to guard the just,\n" +
                    "Now feast on fear, betray the trust.\n" +
                    "Their words like daggers, sharp and cold,\n" +
                    "Their hands in chains of minted gold.\n" +
                    "\n" +
                    "The streets now burn with anger’s cry,\n" +
                    "Yet justice lingers, asks not why.\n" +
                    "For those who rule, who twist and spin,\n" +
                    "Care not for those they trap within.\n" +
                    "\n" +
                    "And lo! The world but turns its face,\n" +
                    "A shattered crown, a fallen grace.\n" +
                    "Yet in the hearts of those who dream,\n" +
                    "A fire stirs—a golden gleam.\n" +
                    "\n" +
                    "For even now, through storm and night,\n" +
                    "There still may rise a beacon’s light.\n" +
                    "A land once great, once strong, once free—\n" +
                    "Shall it remain, or cease to be?", author2),
            new Poem("The Last Coffee Bean", "Epic", "Beneath the sky so dark, so deep,\n" +
                    "A bitter fate began to creep.\n" +
                    "The morning air, so bleak, so mean—\n" +
                    "For lo! There lay one coffee bean.\n" +
                    "\n" +
                    "A lonely seed, so small, so dry,\n" +
                    "Yet held within, a world passed by.\n" +
                    "A thousand cups, a thousand days,\n" +
                    "Had slipped through time in fleeting haze.\n" +
                    "\n" +
                    "Yet now it lay, its brethren gone,\n" +
                    "A relic lost from ages long.\n" +
                    "The kettle cried, the grinder hummed,\n" +
                    "Yet no more beans, the world succumbed.\n" +
                    "\n" +
                    "And so the hero stood in woe,\n" +
                    "No sacred drink, no joyful flow.\n" +
                    "A tear was shed, a silent plea—\n" +
                    "But fate had sealed this tragedy.\n" +
                    "\n" +
                    "So learn, dear soul, from this dark tale:\n" +
                    "Stock thy beans, lest taste should pale!", author3),
            new Poem("The Duck Who Refused To Paddle", "Epic", "The Duck Who Refused to Paddle\n" +
                    "Upon the lake, so calm, so wide,\n" +
                    "One duck declared, “I shall not glide!”\n" +
                    "“My feet shall rest, my wings stay tight,\n" +
                    "I care not for this watery plight.”\n" +
                    "\n" +
                    "The others quacked, they shook their heads,\n" +
                    "“This duck is doomed,” the elders said.\n" +
                    "Yet still he sat, so firm, so proud,\n" +
                    "Unmoving ‘neath the gathering cloud.\n" +
                    "\n" +
                    "The storm then roared, the waves arose,\n" +
                    "The winds now howled like ghostly crows.\n" +
                    "Yet even then, in fury’s might,\n" +
                    "The duck stayed still—a stubborn sight.\n" +
                    "\n" +
                    "And when the tempest ceased its cry,\n" +
                    "The duck still sat, its feathers dry.\n" +
                    "For lo! The shore was near, unseen—\n" +
                    "And patience proved what strength had been.\n" +
                    "\n" +
                    "So hear this tale, ye swift, ye bold:\n" +
                    "Not all who move are wise or gold.", author3),
            new Poem("The Orange King's Folly", "Epic", "Upon a throne of marble white,\n" +
                    "There sat a fool bathed in light.\n" +
                    "His face, a hue of burnished flame,\n" +
                    "His words—a jest, a hollow claim.\n" +
                    "\n" +
                    "With golden towers, high and grand,\n" +
                    "He swore to heal the broken land.\n" +
                    "Yet every vow, once fierce and proud,\n" +
                    "Dissolved like mist, betrayed the crowd.\n" +
                    "\n" +
                    "His tongue, a storm of reckless might,\n" +
                    "Spoke riddles dark and truths contrite.\n" +
                    "He bellowed, raged, and cast his hand,\n" +
                    "Yet knew not maps nor stones nor land.\n" +
                    "\n" +
                    "The scribes, they sighed, the scholars wept,\n" +
                    "As nations laughed, while chaos crept.\n" +
                    "For wisdom fled his empty halls,\n" +
                    "And left but shadows on the walls.\n" +
                    "\n" +
                    "Yet lo! The wheel of fate does turn,\n" +
                    "And thrones shall crack, and banners burn.\n" +
                    "A king once false shall fade from sight,\n" +
                    "As dawn restores the coming light.", author3)
    ));

    public void savePoemsToDatabase(EntityManagerFactory emf)
    {

        for (Poem poem : poems)
        {
            PoemDAO.getInstance(emf).create(poem);
        }
    }

    public PoemDTO getById(int id, EntityManagerFactory emf) throws Exception
    {
        try
        {
            Poem poem = PoemDAO.getInstance(emf).read(id);
            PoemDTO poemDTO = createDTOFromPoem(poem, emf);
            return poemDTO;
        } catch (IndexOutOfBoundsException ex)
        {
            ex.printStackTrace();
            throw new Exception();
        }
    }

    public List<Poem> getAll()
    {
        return poems;
    }

    public Poem setPoem(int id, Poem poem)
    {
        poems.set(id, poem);
        return poem;
    }

    public Poem createPoemFromDTO(PoemDTO poemDTO, EntityManagerFactory emf)
    {
        Poem poem = new Poem(poemDTO.getTitle(), poemDTO.getStyle(), poemDTO.getPoem(), poemDTO.getAuthor());
        return poem;
    }

    public PoemDTO createDTOFromPoem(Poem poem, EntityManagerFactory emf)
    {
        PoemDTO poemDTO = new PoemDTO(poem.getId(), poem.getTitle(), poem.getStyle(), poem.getPoem(), poem.getAuthor());
        return poemDTO;
    }
}
