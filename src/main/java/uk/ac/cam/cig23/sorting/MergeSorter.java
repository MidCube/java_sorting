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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSorter<T> implements Sorter<T> {
  @Override
  public void sort(T[] array, Comparator<T> comparator) {
    // TODO: implement merge sort
    if (array.length > 0) {
      int start = 0;
      int end = array.length-1;
      sort(array,start,end,comparator);
    }
  }

  private void sort(T arr[], int l, int r,Comparator comparator)
  {
    if (l < r)
    {
      // Find the middle point
      int m = (l+r)/2;

      // Sort first and second halves
      sort(arr, l, m, comparator);
      sort(arr , m+1, r,comparator);

      // Merge the sorted halves
      merge(arr, l, m, r,comparator);
    }
  }

  private void merge(T[] array, int l, int m, int r,Comparator comparator) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    ArrayList<T> L= new ArrayList<T>();
    ArrayList<T> R = new ArrayList<T>();

    /*Copy data to temp arrays*/
    for (int i=0; i<n1; ++i)
      L.add(array[l + i]);
    for (int j=0; j<n2; ++j)
      R.add(array[m + 1+ j]);


    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarry array
    int k = l;
    while (i < n1 && j < n2) {
      int result = comparator.compare(L.get(i),R.get(j));
      if (result <1)
      {
        array[k] = L.get(i);
        i++;
      }
      else
      {
        array[k] = R.get(j);
        j++;
      }
      k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1)
    {
      array[k] = L.get(i);
      i++;
      k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2)
    {
      array[k] = R.get(j);
      j++;
      k++;
    }
  }



}
