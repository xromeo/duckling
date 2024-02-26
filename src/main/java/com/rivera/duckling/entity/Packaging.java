package com.rivera.duckling.entity;

import java.util.Objects;

public class Packaging {


    private String material;

    private String protection;

    private Packaging(Builder builder) {
        this.material = builder.material;
        this.protection = builder.protection;
    }

    public String getMaterial() {
        return material;
    }

    public String getProtection() {
        return protection;
    }

    public static class Builder {

        private String material;
        private String protection;

        public Builder material(String material) {
            this.material = material;
            return this;
        }

        public Builder protection(String protection) {
            this.protection = protection;
            return this;
        }

        public Packaging build() {

            validate();
            return new Packaging(this);
        }

        private void validate() {
            Objects.requireNonNull(material, "Material should not be null");
            Objects.requireNonNull(protection, "Protection should not be null");
        }
    }


}
