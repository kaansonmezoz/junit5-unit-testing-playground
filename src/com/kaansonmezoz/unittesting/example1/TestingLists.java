package com.kaansonmezoz.unittesting.example1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestingLists {
    private List<Environment> environments;

    @Test
    public void mockItems(){
        List environments = new ArrayList();

        Utilities utility = new Utilities(environments);

        Environment local = mock(Environment.class);
        Environment dev = mock(Environment.class);
        Environment uat = mock(Environment.class);
        Environment preprod = mock(Environment.class);
        Environment prod = mock(Environment.class);

        environments.add(local);
        environments.add(dev);
        environments.add(uat);
        environments.add(preprod);
        environments.add(prod);

        when(local.getEnviroment()).thenReturn("local");
        when(dev.getEnviroment()).thenReturn("dev");
        when(uat.getEnviroment()).thenReturn("uat");
        when(preprod.getEnviroment()).thenReturn("preprod");
        when(prod.getEnviroment()).thenReturn("prod");

        utility.printEnvironments();
    }

    @Test
    public void mockList_and_mockItems(){
        environments = mock(List.class);

        Environment local = mock(Environment.class);
        Environment dev = mock(Environment.class);
        Environment uat = mock(Environment.class);
        Environment preprod = mock(Environment.class);
        Environment prod = mock(Environment.class);

        environments.add(local);
        environments.add(dev);
        environments.add(uat);
        environments.add(preprod);
        environments.add(prod);

        when(local.getEnviroment()).thenReturn("local");
        when(dev.getEnviroment()).thenReturn("dev");
        when(uat.getEnviroment()).thenReturn("uat");
        when(preprod.getEnviroment()).thenReturn("preprod");
        when(prod.getEnviroment()).thenReturn("prod");

        // creating mocked iterator for enviroments
        ListIterator<Environment> iterator = mock(ListIterator.class);

        // for each uses iterator in the background so we need to mock the iterator of environments
        when(environments.iterator()).thenReturn(iterator);


        /*      we can think for each loops as in the below

            for (Iterator<SomeClass> i = list.iterator(); i.hasNext();) {
                SomeClass item = i.next();

                Something happens here.

            }

         */

        when(iterator.hasNext()).thenReturn(
                true,       // firstItemExists   --> hasNext() value for the first item
                true,     // secondItemExists   --> hasNext() value for the second item
                true,
                true,
                true,
                false        // sixthItemExists ---> hasNext() value for the sixth item
        );
        when(iterator.next()).thenReturn(
                local,      // 1st item
                dev,        // 2nd
                uat,        // 3rd
                preprod,    // 4th
                prod        // 5th
        );

        for(Environment environment: environments){
            System.out.println(environment.getEnviroment());
        }
    }
}
