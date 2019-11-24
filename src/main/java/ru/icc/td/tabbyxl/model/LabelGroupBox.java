/*
 * Copyright 2015-18 Alexey O. Shigarov (shigarov@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.icc.td.tabbyxl.model;

import ru.icc.td.tabbyxl.model.exception.CategoryGroupException;

import java.util.*;

public final class LabelGroupBox extends COwned {
    private static final String GROUP_FIELD_NAME = "GROUP";

    private Set<LabelPair> labelPairs = new HashSet<LabelPair>();

    private List<LabelGroup> labelGroups = new ArrayList<LabelGroup>();

    int numOfLabelGroups() {
        return labelGroups.size();
    }

    private CCategory category;

    void update() {
        initLabelGroups();
        updateCategory();
    }

    private void updateCategory() throws CategoryGroupException {
        int id = 0;
        for (LabelGroup group : labelGroups) {
            CCategory groupCategory = null;
            for (CLabel label : group.labels) {
                CCategory labelCategory = label.getCategory();
                if (null == groupCategory && null != labelCategory) {
                    groupCategory = labelCategory;
                }
                if (null != groupCategory && !labelCategory.equals(groupCategory)) {
                    // TODO generating an exception or warning
                    throw new CategoryGroupException(groupCategory.getName(), labelCategory.getName()
                    );
                }
            }
            if (null == groupCategory) {
                id++;
                try {
                    category = getOwner().getLocalCategoryBox().newCategory(GROUP_FIELD_NAME + id);
                } catch (Exception e) {
                    // TODO is it possible?
                    e.printStackTrace();
                }
            }
            for (CLabel label : group.labels) {
                label.setCategory(category);
            }
        }
    }

    private LabelGroup newLabelGroup() {
        LabelGroup group = new LabelGroup();
        labelGroups.add(group);
        return group;
    }

    private void initLabelGroups() {
        if (labelPairs.size() == 0) return;

        List<LabelPair> tempPairs = new ArrayList(labelPairs.size());
        tempPairs.addAll(labelPairs);

        Stack<CLabel> groupStack = new Stack<CLabel>();
        List<LabelPair> trash = new ArrayList<LabelPair>();

        while (tempPairs.size() > 0) {
            LabelPair pair0 = tempPairs.get(0);
            LabelGroup group = newLabelGroup();

            group.addLabel(pair0.label1);
            group.addLabel(pair0.label2);

            groupStack.push(pair0.label1);
            groupStack.push(pair0.label2);

            tempPairs.remove(0);

            while (!groupStack.empty()) {
                CLabel groupedLabel = groupStack.pop();
                Iterator<LabelPair> pairs = tempPairs.iterator();

                while (pairs.hasNext()) {
                    LabelPair pair = pairs.next();

                    CLabel candidate = groupedLabel.equals(pair.label1) ? pair.label2 :
                            groupedLabel.equals(pair.label2) ? pair.label1 : null;

                    if (null == candidate) continue;

                    if (!groupStack.contains(candidate)) {
                        groupStack.push(candidate);
                        group.labels.add(candidate);
                    }
                    trash.add(pair);
                    pairs.remove();
                }
            }
            tempPairs.removeAll(trash);
            trash.clear();
        }
    }

    void group(CLabel label1, CLabel label2) {
        //if ( ! label1.equals( label2 ) )
        labelPairs.add(new LabelPair(label1, label2));
    }

    public String trace() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grouped labels:\r\n\t");

        if (labelPairs.size() == 0) {
            sb.append("no pairs");
        } else {
            int c = 0;
            for (LabelPair pair : labelPairs) {
                sb.append(String.format("(\"%s\", \"%s\")", pair.label1.getValue(), pair.label2.getValue()));
                if (c < labelPairs.size() - 1) sb.append(", ");
                c++;
            }
        }
        return sb.toString();
    }

    LabelGroupBox(CTable owner) {
        //this.owner = owner;
        super(owner);
    }

    private class LabelGroup {
        private Set<CLabel> labels = new HashSet<CLabel>();

        private void addLabel(CLabel label) {
            labels.add(label);
        }
    }

    private class LabelPair {
        private CLabel label1;
        private CLabel label2;

        private LabelPair(CLabel label1, CLabel label2) {
            this.label1 = label1;
            this.label2 = label2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LabelPair pair = (LabelPair) o;

            if (label1 == pair.label1 && label2 == pair.label2) return true;
            if (label1 == pair.label2 && label2 == pair.label1) return true;

            return false;
        }

        @Override
        public int hashCode() {
            int result = label1 != null ? label1.hashCode() : 0;
            result += label2 != null ? label2.hashCode() : 0;
            return result;
        }
    }
}


