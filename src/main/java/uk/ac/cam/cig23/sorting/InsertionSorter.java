/*
 * Copyright 2020 David Berry <dgb37@cam.ac.uk>, C.I. Griffiths
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.cig23.sorting;

import java.util.Comparator;

public class InsertionSorter<T> implements Sorter<T> {
  @Override
  public void sort(T[] array, Comparator<T> comparator) {
    // TODO: implement in-place insertion sort without using a temporary array
    //if length is 0 or 1 then it is already sorted so no need to do anything
    if (array.length > 1) {
      //first item is already sorted. Loop through increasing length of sorted portion each time
      for (int i = 1; i<array.length;i++) {
        T swapper = array[i];
        for (int j=i-1; j>=0;j--) {
          int result = comparator.compare(swapper,array[j]);
          if (result < 0) {
            array[j+1] = array[j];
            array[j] = swapper;
          } else {
            break;
          }
        }

      }
    }
  }
}
