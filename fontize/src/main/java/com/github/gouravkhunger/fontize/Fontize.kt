/*
 * MIT License
 *
 * Copyright (c) 2021 Gourav Khunger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.gouravkhunger.fontize

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.res.ResourcesCompat
import androidx.preference.PreferenceManager

class Fontize(private val context: Context) {

    private lateinit var sharedPref: SharedPreferences

    fun setDefaultFont(resourceId: Int) {
        sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val fontId = sharedPref.getInt("fontFamily", ResourcesCompat.ID_NULL)

        if (fontId == ResourcesCompat.ID_NULL) {
            sharedPref.edit()
                .putInt("fontFamily", resourceId)
                .apply()
        }
    }

    fun updateFont(resourceId: Int) {
        sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPref.edit()
            .putInt("fontFamily", resourceId)
            .apply()
    }
}
