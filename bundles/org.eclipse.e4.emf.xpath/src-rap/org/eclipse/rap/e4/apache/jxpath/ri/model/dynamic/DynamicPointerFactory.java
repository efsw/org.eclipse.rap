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
package org.eclipse.rap.e4.apache.jxpath.ri.model.dynamic;

import java.util.Locale;

import org.eclipse.rap.e4.apache.jxpath.DynamicPropertyHandler;
import org.eclipse.rap.e4.apache.jxpath.JXPathBeanInfo;
import org.eclipse.rap.e4.apache.jxpath.JXPathIntrospector;
import org.eclipse.rap.e4.apache.jxpath.ri.QName;
import org.eclipse.rap.e4.apache.jxpath.ri.model.NodePointer;
import org.eclipse.rap.e4.apache.jxpath.ri.model.NodePointerFactory;
import org.eclipse.rap.e4.apache.jxpath.ri.model.beans.NullPointer;
import org.eclipse.rap.e4.apache.jxpath.util.ValueUtils;

/**
 * Implements NodePointerFactory for Dynamic classes like Map.
 *
 * @author Dmitri Plotnikov
 * @version $Revision: 652845 $ $Date: 2008-05-02 12:46:46 -0500 (Fri, 02 May 2008) $
 */
public class DynamicPointerFactory implements NodePointerFactory {

    /**
     * Factory order constant.
     */
    public static final int DYNAMIC_POINTER_FACTORY_ORDER = 800;

    public int getOrder() {
        return DYNAMIC_POINTER_FACTORY_ORDER;
    }

    public NodePointer createNodePointer(
        QName name,
        Object bean,
        Locale locale) {
        JXPathBeanInfo bi = JXPathIntrospector.getBeanInfo(bean.getClass());
        if (bi.isDynamic()) {
            DynamicPropertyHandler handler =
                ValueUtils.getDynamicPropertyHandler(
                    bi.getDynamicPropertyHandlerClass());
            return new DynamicPointer(name, bean, handler, locale);
        }
        return null;
    }

    public NodePointer createNodePointer(
        NodePointer parent,
        QName name,
        Object bean) {
        if (bean == null) {
            return new NullPointer(parent, name);
        }

        JXPathBeanInfo bi = JXPathIntrospector.getBeanInfo(bean.getClass());
        if (bi.isDynamic()) {
            DynamicPropertyHandler handler =
                ValueUtils.getDynamicPropertyHandler(
                    bi.getDynamicPropertyHandlerClass());
            return new DynamicPointer(parent, name, bean, handler);
        }
        return null;
    }
}
