import 'package:flutter/material.dart';

import 'package:app_personal/screens/pantalla_inicio.dart';
import 'package:app_personal/screens/pantalla_perfil.dart';
import 'package:app_personal/screens/pantalla_hobbies.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Mi App Personal",
      home: PantallaInicio(),
      //home: PantallaPerfil(),
      //home: PantallaHobbies(),
    );
  }
}