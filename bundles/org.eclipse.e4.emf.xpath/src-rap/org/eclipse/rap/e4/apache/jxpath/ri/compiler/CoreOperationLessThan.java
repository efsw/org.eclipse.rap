/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eclipse.rap.e4.apache.jxpath.ri.compiler;

/**
 * Implementation of {@link Expression} for the operation "&lt;".
 *
 * @author Dmitri Plotnikov
 * @version $Revision: 652845 $ $Date: 2008-05-02 12:46:46 -0500 (Fri, 02 May 2008) $
 */
public class CoreOperationLessThan extends CoreOperationRelationalExpression {

    /**
     * Create a new CoreOperationLessThan.
     * @param arg1 left Expression
     * @param arg2 right Expression
     */
    public CoreOperationLessThan(Expression arg1, Expression arg2) {
        super(new Expression[] { arg1, arg2 });
    }

    protected boolean evaluateCompare(int compare) {
        return compare < 0;
    }

    public String getSymbol() {
        return "<";
    }
}
