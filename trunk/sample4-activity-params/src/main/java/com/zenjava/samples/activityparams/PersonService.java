package com.zenjava.samples.activityparams;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a hard coded instance of a PersonService for demonstration purposes only. In a
 * real system, the Person information would be stored in a database or in a file and most
 * likely accessed via a remote server.
 */
public class PersonService
{
    private List<Person> persons;

    public PersonService()
    {
        this.persons = new ArrayList<Person>();
        long nextId = 0;

        // info taken from: http://www.skwirk.com.au/p-c_s-17_u-144_t-437_c-1540/VIC/5/Famous-Indigenous-Australians/

        this.persons.add(new Person(nextId++, "Cathy", "Freeman",
                "Cathy Freeman is one of the most well-known Indigenous Australians. Her skills and"
                        + " achievements as a runner have been seen by people all over the world as she"
                        + " has competed in multiple Olympic Games.\n\n"
                        + "Freeman is a descendant of the Kuku Yalanji people and was born in Mackay, Queensland"
                        + " in 1973. Her greatest achievement was being the first Aboriginal person to win an"
                        + " Olympic gold medal in an individual event (400 metres sprint). Freeman was further"
                        + " honoured by being given a vital role at the Sydney Olympics (2000), which was the"
                        + " lighting of the Olympic flame during the opening ceremony."));

        this.persons.add(new Person(nextId++, "Albert", "Namatjira",
                "Albert Namatjira was the first Indigenous person to become an internationally renowned"
                        + " artist. He was born in 1902 near Alice Springs and always enjoying painting"
                        + " whilst he was growing up. It was not until 1934 (aged 32 years old) that he"
                        + " began to paint seriously. A man named Rex Battarbee taught Namatjira a lot about"
                        + " the skill of painting, and Namatjira showed Rex some of the best places to paint"
                        + " in Australia. Namatjira's art was very different to traditional Indigenous art.\n\n"
                        + "Namatjira's first exhibition went on show in 1936 in Melbourne, where his paintings"
                        + " sold out. His success continued and his paintings became very valuable. Although he"
                        + " had become very successful and made a great deal of money, Namatjira still had to"
                        + " follow the strict laws placed on Indigenous people during that time. He was not"
                        + " allowed to buy a home or any land, and could not rent a property.\n\n"
                        + "In 1957, Namatjira became the first Indigenous person to become an Australian"
                        + " citizen. His art and his life made governments aware of how Indigenous people"
                        + " were being treated in Australia during that period. He died in 1959."));

        this.persons.add(new Person(nextId++, "Noel", "Pearson",
                "Noel Pearson is a well know and respected Indigenous activist who has done a great deal for"
                        + " the rights of Indigenous Australians. Born in Cooktown, Pearson then grew up in"
                        + " a Lutheran mission Hope Vale.\n\n"
                        + "Pearson was involved in the establishment of many Indigenous organisations on"
                        + " the Cape York Peninsula (health councils, development corporations). All of"
                        + " the organisations Pearson has been involved in have been designed to help the"
                        + " Indigenous people of Cape York."));

        this.persons.add(new Person(nextId++, "Oodgeroo", "Nooncal",
                "Kath Walker, whose Indigenous name was Oodgeroo Nooncal, was Australia's first Indigenous"
                        + " poet to gain recognition from around the world. Walker was born in 1920 and"
                        + " began writing poetry from an early age. She grew up on North Stradbroke"
                        + " Island, which became to inspiration for much of her poetry.\n\n"
                        + "Walker finally had her poetry published when she was in her forties. She was"
                        + " also a strong advocate for Indigenous rights. During the 1960s, Walker began"
                        + " campaigning for equality. She travelled the world fighting for the rights of"
                        + " Australia's Indigenous people. She died in 1993."));

        this.persons.add(new Person(nextId++, "Neville", "Bonner",
                "Neville Bonner was Australia's first Indigenous politician. He then became a senator for"
                        + " Queensland and served for twelve years (1971-1983). He was also the first"
                        + " Indigenous person to sit in federal parliament.\n\n"
                        + "A central focus to his work as a politician involved improving the conditions"
                        + " of his fellow Indigenous people. Bonner helped change the face of Indigenous"
                        + " rights in Australia. He was an honest man who never let anger dominate his work."));

        this.persons.add(new Person(nextId++, "Pat", "O'Shane",
                "Pat O'Shane was born in 1941 near Cairns. She is a descendant of the Yalangi Indigenous"
                        + " people. O'Shane was the fist Aboriginal teacher in Queensland and then years"
                        + " later, in 1982, she became the first female head of a state government"
                        + " department. In 1987 she achieved another first by becoming the first Indigenous"
                        + " Australian to become a magistrate in the New South Wales courts."
        ));
    }

    public List<Person> findAllPersons()
    {
        return persons;
    }

    public Person getPerson(long id)
    {
        for (Person person : persons)
        {
            if (person.getId() == id)
            {
                return person;
            }
        }
        return null;
    }

}
