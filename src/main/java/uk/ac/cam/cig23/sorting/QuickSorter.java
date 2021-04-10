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

public class QuickSorter<T> implements Sorter<T> {
  @Override
  public void sort(T[] array, Comparator<T> comparator) {
    // TODO: implement in-place quick sort without using temporary arrays
    if (array.length > 0) {
      quickSort(array, comparator, 0, array.length - 1);
    }
  }

  void quickSort(T[] array, Comparator comparator, int start, int end){

    int partition = partition(array, comparator, start, end);

    if(partition-1>start) {
      quickSort(array,comparator, start, partition - 1);
    }
    if(partition+1<end) {
      quickSort(array,comparator, partition + 1, end);
    }
  }

  int partition(T[] array,Comparator comparator, int start, int end){
    int pivot = start;

    for(int i=end; i>start; i--){
      int result = comparator.compare(array[pivot],array[i]);
      if(result < 0){
        T temp= array[end];
        array[end]=array[i];
        array[i]=temp;
        end--;
      }
    }

    T temp = array[end];
    array[end] = array[pivot];
    array[start] = temp;

    return end;
  }
}
