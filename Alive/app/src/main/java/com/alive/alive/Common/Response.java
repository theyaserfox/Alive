package com.alive.alive.Common;

import android.app.Dialog;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by yessir on 26/09/14.
 */
/// <summary>
/// A type which handels the end result of the function and keep track of errors occured during runtime of it
/// </summary>
public class Response
{
    public ResponseState State;
    public List<Error> Errors;// = new List<Error>();
    public List<Object> Returns = new List<Object>() {
        @Override
        public void add(int i, Object o) {

        }

        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean addAll(int i, Collection<?> objects) {
            return false;
        }

        @Override
        public boolean addAll(Collection<?> objects) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> objects) {
            return false;
        }

        @Override
        public Object get(int i) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Iterator<Object> iterator() {
            return null;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Object> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Object> listIterator(int i) {
            return null;
        }

        @Override
        public Object remove(int i) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> objects) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> objects) {
            return false;
        }

        @Override
        public Object set(int i, Object o) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public List<Object> subList(int i, int i2) {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            return null;
        }
    };

    public Response() { State = ResponseState.SUCCESS; }



    //public void ShowErrors()
    //{
    //    foreach (Error error in Errors)
    //    {
            //Toast.makeText(getClass(), "Hello", Toast.LENGTH_LONG).show();
            //Dialog("Hello");
            //MessageBox.Show(error.ErrorMessage);
    //    }
    //}
}