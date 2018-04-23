package com.lwb.Study.effectivejava;

/**
 * 遇到多个参数时，考虑用构建器创建对象
 */
public class Person {

    /** 必填参数 */
    private String name;
    private Integer age;
    private String sex;

    /** 可选参数 */
    private String phone;
    private String email;

    /**
     * 构建器
     */
    public static class PersonBuilder implements Builder<Person> {

        private String name;
        private Integer age;
        private String sex;

        private String phone;
        private String email;

        public PersonBuilder(String name, Integer age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public Person build() {
            return new Person(this);
        }
    }

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
