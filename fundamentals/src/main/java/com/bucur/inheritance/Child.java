package com.bucur.inheritance;

public class Child extends Parent {

    public void testFieldsFromParent() {
        String staticFieldOnParentInstance = Parent.staticField;
        String staticFieldOnChildInstance = Child.staticField;

        assert staticFieldOnParentInstance.equals(staticFieldOnChildInstance);

        // cant call private
        String one = super.defaultField;
        String two = super.protectedField;
        String three = super.publicField;
    }
}
