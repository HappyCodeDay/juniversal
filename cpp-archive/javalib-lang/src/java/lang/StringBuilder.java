/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 *  JUniversal CHANGES:
 *  The append method for StringBuffer was removed as StringBuffer isn't supported in JUniversal.
 */

package java.lang;

/**
 * A modifiable {@link CharSequence sequence of characters} for use in creating and modifying
 * Strings. This class is intended as a direct replacement of {@link StringBuffer} for
 * non-concurrent use; unlike {@code StringBuffer} this class is not synchronized for thread safety.
 * <p>
 * The majority of the modification methods on this class return {@code StringBuilder}, so that,
 * like {@code StringBuffer}s, they can be used in chaining method calls together. For example,
 * {@code new StringBuilder("One
 * should ").append("always strive ").append("to achieve Harmony")}.
 * 
 * JUniversal REMOVED:
 * 
 * codePoint (aka surrogate) related methods, for Unicode characters > 65K, aren't currently
 * supported and were removed.
 * 
 * serialization related methods
 * 
 * append & insert methods for double and float
 * 
 * 
 * @see CharSequence
 * @see Appendable
 * @see StringBuffer
 * @see String
 * 
 * @since 1.5
 * 
 */
public final class StringBuilder extends AbstractStringBuilder implements Appendable, CharSequence {
    /**
     * Constructs an instance with an initial capacity of {@code 16}.
     * 
     * @see #capacity()
     */
    public StringBuilder() {
        super();
    }

    /**
     * Constructs an instance with the specified capacity.
     *
     * @param capacity
     *            the initial capacity to use.
     * @throws NegativeArraySizeException
     *             if the specified {@code capacity} is negative.
     * @see #capacity()
     */
    public StringBuilder(int capacity) {
        super(capacity);
    }

    /**
     * Constructs an instance that's initialized with the contents of the
     * specified {@code CharSequence}. The capacity of the new builder will be
     * the length of the {@code CharSequence} plus 16.
     *
     * @param seq
     *            the {@code CharSequence} to copy into the builder.
     * @throws NullPointerException
     *            if {@code seq} is {@code null}.
     */
    public StringBuilder(CharSequence seq) {
        super(seq.toString());
    }

    /**
     * Constructs an instance that's initialized with the contents of the
     * specified {@code String}. The capacity of the new builder will be the
     * length of the {@code String} plus 16.
     *
     * @param str
     *            the {@code String} to copy into the builder.
     * @throws NullPointerException
     *            if {@code str} is {@code null}.
     */
    public StringBuilder(String str) {
        super(str);
    }

    /**
     * Appends the string representation of the specified {@code boolean} value.
     * The {@code boolean} value is converted to a String according to the rule
     * defined by {@link String#valueOf(boolean)}.
     *
     * @param b
     *            the {@code boolean} value to append.
     * @return this builder.
     * @see String#valueOf(boolean)
     */
    public StringBuilder append(boolean b) {
        append0(b ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
        return this;
    }

    /**
     * Appends the string representation of the specified {@code char} value.
     * The {@code char} value is converted to a string according to the rule
     * defined by {@link String#valueOf(char)}.
     *
     * @param c
     *            the {@code char} value to append.
     * @return this builder.
     * @see String#valueOf(char)
     */
    public StringBuilder append(char c) {
        append0(c);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code int} value. The
     * {@code int} value is converted to a string according to the rule defined
     * by {@link String#valueOf(int)}.
     *
     * @param i
     *            the {@code int} value to append.
     * @return this builder.
     * @see String#valueOf(int)
     */
    public StringBuilder append(int i) {
        append0(Integer.toString(i));
        return this;
    }

    /**
     * Appends the string representation of the specified {@code long} value.
     * The {@code long} value is converted to a string according to the rule
     * defined by {@link String#valueOf(long)}.
     *
     * @param lng
     *            the {@code long} value.
     * @return this builder.
     * @see String#valueOf(long)
     */
    public StringBuilder append(long lng) {
        append0(Long.toString(lng));
        return this;
    }

    /**
     * Appends the string representation of the specified {@code Object}.
     * The {@code Object} value is converted to a string according to the rule
     * defined by {@link String#valueOf(Object)}.
     *
     * @param obj
     *            the {@code Object} to append.
     * @return this builder.
     * @see String#valueOf(Object)
     */
    public StringBuilder append(Object obj) {
        if (obj == null) {
            appendNull();
        } else {
            append0(obj.toString());
        }
        return this;
    }

    /**
     * Appends the contents of the specified string. If the string is {@code
     * null}, then the string {@code "null"} is appended.
     *
     * @param str
     *            the string to append.
     * @return this builder.
     */
    public StringBuilder append(String str) {
        append0(str);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code char[]}.
     * The {@code char[]} is converted to a string according to the rule
     * defined by {@link String#valueOf(char[])}.
     *
     * @param ch
     *            the {@code char[]} to append..
     * @return this builder.
     * @see String#valueOf(char[])
     */
    public StringBuilder append(char[] ch) {
        append0(ch);
        return this;
    }

    /**
     * Appends the string representation of the specified subset of the {@code
     * char[]}. The {@code char[]} value is converted to a String according to
     * the rule defined by {@link String#valueOf(char[],int,int)}.
     *
     * @param str
     *            the {@code char[]} to append.
     * @param offset
     *            the inclusive offset index.
     * @param len
     *            the number of characters.
     * @return this builder.
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code offset} and {@code len} do not specify a valid
     *             subsequence.
     * @see String#valueOf(char[],int,int)
     */
    public StringBuilder append(char[] str, int offset, int len) {
        append0(str, offset, len);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code CharSequence}.
     * If the {@code CharSequence} is {@code null}, then the string {@code
     * "null"} is appended.
     *
     * @param csq
     *            the {@code CharSequence} to append.
     * @return this builder.
     */
    public StringBuilder append(CharSequence csq) {
        if (csq == null) {
            appendNull();
        } else {
            append0(csq.toString());
        }
        return this;
    }

    /**
     * Appends the string representation of the specified subsequence of the
     * {@code CharSequence}. If the {@code CharSequence} is {@code null}, then
     * the string {@code "null"} is used to extract the subsequence from.
     *
     * @param csq
     *            the {@code CharSequence} to append.
     * @param start
     *            the beginning index.
     * @param end
     *            the ending index.
     * @return this builder.
     * @throws IndexOutOfBoundsException
     *             if {@code start} or {@code end} are negative, {@code start}
     *             is greater than {@code end} or {@code end} is greater than
     *             the length of {@code csq}.
     */
    public StringBuilder append(CharSequence csq, int start, int end) {
        append0(csq, start, end);
        return this;
    }

    /**
     * Deletes a sequence of characters specified by {@code start} and {@code
     * end}. Shifts any remaining characters to the left.
     * 
     * @param start
     *            the inclusive start index.
     * @param end
     *            the exclusive end index.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code start} is less than zero, greater than the current
     *             length or greater than {@code end}.
     */
    public StringBuilder delete(int start, int end) {
        delete0(start, end);
        return this;
    }

    /**
     * Deletes the character at the specified index. shifts any remaining
     * characters to the left.
     * 
     * @param index
     *            the index of the character to delete.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index} is less than zero or is greater than or
     *             equal to the current length.
     */
    public StringBuilder deleteCharAt(int index) {
        deleteCharAt0(index);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code boolean} value
     * at the specified {@code offset}. The {@code boolean} value is converted
     * to a string according to the rule defined by
     * {@link String#valueOf(boolean)}.
     *
     * @param offset
     *            the index to insert at.
     * @param b
     *            the {@code boolean} value to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length}.
     * @see String#valueOf(boolean)
     */
    public StringBuilder insert(int offset, boolean b) {
        insert0(offset, b ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code char} value at
     * the specified {@code offset}. The {@code char} value is converted to a
     * string according to the rule defined by {@link String#valueOf(char)}.
     *
     * @param offset
     *            the index to insert at.
     * @param c
     *            the {@code char} value to insert.
     * @return this builder.
     * @throws IndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(char)
     */
    public StringBuilder insert(int offset, char c) {
        insert0(offset, c);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code int} value at
     * the specified {@code offset}. The {@code int} value is converted to a
     * String according to the rule defined by {@link String#valueOf(int)}.
     *
     * @param offset
     *            the index to insert at.
     * @param i
     *            the {@code int} value to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(int)
     */
    public StringBuilder insert(int offset, int i) {
        insert0(offset, Integer.toString(i));
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code long} value at
     * the specified {@code offset}. The {@code long} value is converted to a
     * String according to the rule defined by {@link String#valueOf(long)}.
     *
     * @param offset
     *            the index to insert at.
     * @param l
     *            the {@code long} value to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {code length()}.
     * @see String#valueOf(long)
     */
    public StringBuilder insert(int offset, long l) {
        insert0(offset, Long.toString(l));
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code Object} at the
     * specified {@code offset}. The {@code Object} value is converted to a
     * String according to the rule defined by {@link String#valueOf(Object)}.
     *
     * @param offset
     *            the index to insert at.
     * @param obj
     *            the {@code Object} to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(Object)
     */
    public StringBuilder insert(int offset, Object obj) {
        insert0(offset, obj == null ? "null" : obj.toString()); //$NON-NLS-1$
        return this;
    }

    /**
     * Inserts the specified string at the specified {@code offset}. If the
     * specified string is null, then the String {@code "null"} is inserted.
     *
     * @param offset
     *            the index to insert at.
     * @param str
     *            the {@code String} to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     */
    public StringBuilder insert(int offset, String str) {
        insert0(offset, str);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code char[]} at the
     * specified {@code offset}. The {@code char[]} value is converted to a
     * String according to the rule defined by {@link String#valueOf(char[])}.
     *
     * @param offset
     *            the index to insert at.
     * @param ch
     *            the {@code char[]} to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(char[])
     */
    public StringBuilder insert(int offset, char[] ch) {
        insert0(offset, ch);
        return this;
    }

    /**
     * Inserts the string representation of the specified subsequence of the
     * {@code char[]} at the specified {@code offset}. The {@code char[]} value
     * is converted to a String according to the rule defined by
     * {@link String#valueOf(char[],int,int)}.
     *
     * @param offset
     *            the index to insert at.
     * @param str
     *            the {@code char[]} to insert.
     * @param strOffset
     *            the inclusive index.
     * @param strLen
     *            the number of characters.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}, or {@code strOffset} and {@code strLen} do
     *             not specify a valid subsequence.
     * @see String#valueOf(char[],int,int)
     */
    public StringBuilder insert(int offset, char[] str, int strOffset,
            int strLen) {
        insert0(offset, str, strOffset, strLen);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code CharSequence}
     * at the specified {@code offset}. The {@code CharSequence} is converted
     * to a String as defined by {@link CharSequence#toString()}. If {@code s}
     * is {@code null}, then the String {@code "null"} is inserted.
     *
     * @param offset
     *            the index to insert at.
     * @param s
     *            the {@code CharSequence} to insert.
     * @return this builder.
     * @throws IndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see CharSequence#toString()
     */
    public StringBuilder insert(int offset, CharSequence s) {
        insert0(offset, s == null ? "null" : s.toString()); //$NON-NLS-1$
        return this;
    }

    /**
     * Inserts the string representation of the specified subsequence of the
     * {@code CharSequence} at the specified {@code offset}. The {@code
     * CharSequence} is converted to a String as defined by
     * {@link CharSequence#subSequence(int, int)}. If the {@code CharSequence}
     * is {@code null}, then the string {@code "null"} is used to determine the
     * subsequence.
     *
     * @param offset
     *            the index to insert at.
     * @param s
     *            the {@code CharSequence} to insert.
     * @param start
     *            the start of the subsequence of the character sequence.
     * @param end
     *            the end of the subsequence of the character sequence.
     * @return this builder.
     * @throws IndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}, or {@code start} and {@code end} do not
     *             specify a valid subsequence.
     * @see CharSequence#subSequence(int, int)
     */
    public StringBuilder insert(int offset, CharSequence s, int start, int end) {
        insert0(offset, s, start, end);
        return this;
    }

    /**
     * Replaces the specified subsequence in this builder with the specified
     * string.
     * 
     * @param start
     *            the inclusive begin index.
     * @param end
     *            the exclusive end index.
     * @param str
     *            the replacement string.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code start} is negative, greater than the current
     *             {@code length()} or greater than {@code end}.
     * @throws NullPointerException
     *            if {@code str} is {@code null}.
     */
    public StringBuilder replace(int start, int end, String str) {
        replace0(start, end, str);
        return this;
    }

    /**
     * Reverses the order of characters in this builder.
     * 
     * @return this buffer.
     */
    public StringBuilder reverse() {
        reverse0();
        return this;
    }

    /**
     * Returns the contents of this builder.
     * 
     * @return the string representation of the data in this builder.
     */
    @Override
    public String toString() {
        /* Note: This method is required to workaround a compiler bug
         * in the RI javac (at least in 1.5.0_06) that will generate a
         * reference to the non-public AbstractStringBuilder if we don't
         * override it here.
         */
        return super.toString();
    }
}