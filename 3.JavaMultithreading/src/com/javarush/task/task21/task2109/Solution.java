package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

import java.util.Objects;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException
            {
                return (A) super.clone();
            }

        @Override
        public boolean equals(Object o)
            {
                if (this == o) return true;
                if (!( o instanceof A )) return false;
                A a = (A) o;
                return i == a.i && j == a.j;
            }

        @Override
        public int hashCode()
            {
                return Objects.hash(i, j);
            }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException
            {
                throw new CloneNotSupportedException();

               // return super.clone();
            }

        @Override
        public boolean equals(Object o)
            {
                if (this == o) return true;
                if (!( o instanceof B )) return false;
                if (!super.equals(o)) return false;
                B b = (B) o;
                return Objects.equals(name, b.name);
            }

        @Override
        public int hashCode()
            {
                return Objects.hash(super.hashCode(), name);
            }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException
            {
                return new C(this.getI(), this.getJ(), this.getName());
            }

        @Override
        public boolean equals(Object o)
            {
                return super.equals(o);
            }

        @Override
        public int hashCode()
            {
                return super.hashCode();
            }
    }

    public static void main(String[] args) {

    }
}
