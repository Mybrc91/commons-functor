/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.functor.example.kata.one;

import org.apache.commons.functor.BinaryFunction;
import org.apache.commons.functor.UnaryFunction;
import org.apache.commons.functor.adapter.RightBoundFunction;

/**
 * @version $Revision$ $Date$
 * @author Rodney Waldhoff
 */
public class Divide implements BinaryFunction {
    public Object evaluate(Object left, Object right) {
        return evaluate((Number) left,(Number) right);
    }

    public Object evaluate(Number left, Number right) {
        return new Integer(left.intValue() / right.intValue());
    }

    public static Divide instance() {
        return INSTANCE;
    }

    public static UnaryFunction by(int factor) {
        return new RightBoundFunction(instance(),new Integer(factor));
    }

    private static Divide INSTANCE = new Divide();
}
