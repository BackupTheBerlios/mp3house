/*
 * Created on Feb 20, 2004 4:54:26 PM
 * SimpleQueue.java
 * 
 * Copyright (C) 2003  MP3House Development Group
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 */
package org.mp3house.gg.core;

/**
 * @author Vijay
 * Simple Queue 
 */
public class SimpleQueue {
    private Object[] queue;
    private int size; // size of the queue
    private int top;  // for next insertion
    private int base; // for next removal

    public SimpleQueue(int capacity) {
        queue = new Object[capacity];
        size = top = base = 0; 
    }
  
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
  
    public void enqueue(Object item) {
        if (isFull()) {
            throw new RuntimeException("queue overflow");
        } else {
            queue[top++] = item;
            if (top == queue.length) {
                top = 0;
            }
            ++size;
        }
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("queue underflow");
        } else {
            Object item = queue[base++];
            if (base == queue.length) {
                base = 0;
            }
            --size;
            return item; 
        }
    }
}
