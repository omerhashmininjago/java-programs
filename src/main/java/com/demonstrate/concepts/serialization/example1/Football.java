package com.demonstrate.concepts.serialization.example1;

import java.io.Serializable;

/**
 * We don't need to explicitly give a no-arg constructor for deserialization  in this case
 * Reason being - the direct superclass of Football is Object (does not implement Serializable)
 * and it already has a no-arg constructor
 *
 * If Football had another superclass between Object which was not implementing Serializable
 * then that superclass would have had to have a mandatory no-args constructor
 * Else an error will be detected at runtime
 *
 */
public class Football implements Serializable {

    /**
     * User defined serialVersionUID is always preferable
     * This ensures the Sender which Serialized the object
     * And the receiver Deserializing the object are loading the same version of the class
     *
     * If the versions are not compatible, an InvalidClassException is thrown
     *
     * If we don't define a serialVersionUID, then the compiler will auto generate one
     * Drawback of this is, the generation of the UID is compiler implementation specific
     * Hence can vary from compiler to compiler
     * This can result in an InvalidClassException
     */
    private static final long serialVersionUID = 10000001l;
}
