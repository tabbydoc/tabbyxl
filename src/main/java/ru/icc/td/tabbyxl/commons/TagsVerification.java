package ru.icc.td.tabbyxl.commons;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TagsVerification {
    public static enum EntTags implements Collection<String> {PERCENT, CAUSE_OF_DEATH, CITY, COUNTRY, CRIMINAL_CHARGE, DATE, IDEOLOGY, LOCATION, MISC, MODIFIER,
        NATIONALITY, NUMBER, ORGANIZATION, PERSON, RELIGION, STATE_OR_PROVINCE, TITLE, URL, DURATION, GPE, N_A;

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<String> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(String s) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };

    public static EntTags getTagByStr(String s){
        try {
            return EntTags.valueOf(s);
        }
        catch (IllegalArgumentException e){
            return EntTags.N_A;
        }
    }

    public static EntTags getTypeForList(List<String> list){
        EntTags result = EntTags.N_A;
        if (list.isEmpty() == false){
            result = getTagByStr(list.get(0));
            for(int i=1; i< list.size(); i++){
                if (getTagByStr(list.get(i)) != result) return EntTags.N_A;
            }
        }
        return result;
    }

}
