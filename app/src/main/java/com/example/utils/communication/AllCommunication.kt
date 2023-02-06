package com.example.utils.communication

import com.example.utils.event.Event
import com.example.utils.navigation.NavigationCommand

interface NavigationCommunication : Communication<Event<NavigationCommand>> {
    class Base : Communication.Base<Event<NavigationCommand>>(), NavigationCommunication
}