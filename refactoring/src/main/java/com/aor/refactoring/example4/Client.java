package com.aor.refactoring.example4;

public class Client extends Person {

    private String name, phone;
    public Client(String name, String phone) {
        this.name=name;
        this.phone=phone;

    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}
