package fr.isen.teamui.utils

interface OnItemClickListener<T> {
    abstract fun onItemClick(item: T, position: Int)
}