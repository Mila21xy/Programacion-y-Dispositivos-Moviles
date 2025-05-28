import 'package:flutter/material.dart';
import '../utils/app_colors.dart';
import '../utils/app_texts.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(AppTexts.tituloHobbies),
        backgroundColor: AppColors.primaryColor,
        foregroundColor: AppColors.textLight,
        centerTitle: true,
        elevation: 2,
      ),
      backgroundColor: AppColors.backgroundColor,
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          children: [
            // Título principal
            Container(
              width: double.infinity,
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                color: AppColors.cardColor,
                borderRadius: BorderRadius.circular(15),
              ),
              child: Column(
                children: [
                  Icon(
                    Icons.favorite,
                    color: AppColors.accentColor,
                    size: 40,
                  ),
                  const SizedBox(height: 10),
                  Text(
                    AppTexts.descripcionHobbies,
                    style: TextStyle(
                      fontSize: 18,
                      color: AppColors.textDark,
                      fontWeight: FontWeight.w500,
                    ),
                    textAlign: TextAlign.center,
                  ),
                ],
              ),
            ),
            const SizedBox(height: 30),

            // Tarjeta de Desarrollo de Software
            _buildHobbyCard(
              AppTexts.hobbyProgramacion,
              AppTexts.descripcionProgramacion,
              Icons.code,
              'https://nuc.edu/wp-content/uploads/2024/12/blog-59-desarrollador-de-software-768x511.jpg',
            ),
            const SizedBox(height: 20),

            // Tarjeta de Arte Fotográfico
            _buildHobbyCard(
              AppTexts.hobbyFotografia,
              AppTexts.descripcionFotografia,
              Icons.camera_alt,
              'https://wallpapers.com/images/hd/green-landscape-1920-x-1200-wallpaper-1l8f8w08rgeiq19i.jpg',
            ),
            const SizedBox(height: 20),

            // Tarjeta de Lectura
            _buildHobbyCard(
              AppTexts.hobbyLectura,
              AppTexts.descripcionLectura,
              Icons.book,
              'https://img.freepik.com/premium-photo/there-is-little-girl-looking-out-window-fantasy-scene-generative-ai_955884-4998.jpg',
            ),
            const SizedBox(height: 20),

            // Tarjeta de Música
            _buildHobbyCard(
              AppTexts.hobbyMusica,
              AppTexts.descripcionMusica,
              Icons.music_note,
              'https://media1.tenor.com/m/djMMseHv2cEAAAAd/sabrina-carpenter-gifsmooncantsend.gif',
            ),
            const SizedBox(height: 20),

            // Tarjeta de Deportes
            _buildHobbyCard(
              AppTexts.hobbyDeportes,
              AppTexts.descripcionDeportes,
              Icons.sports_soccer,
              'https://s1.sportstatics.com/relevo/www/multimedia/202408/27/media/cortadas/remate-voleibol-RxdpVgVgnGuxaVoHtus5HcI-1200x648@Relevo.JPG',
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildHobbyCard(String titulo, String descripcion, IconData icono, String imagenUrl) {
    return Container(
      width: double.infinity,
      decoration: BoxDecoration(
        color: AppColors.cardColor,
        borderRadius: BorderRadius.circular(15),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Image
          ClipRRect(
            borderRadius: const BorderRadius.only(
              topLeft: Radius.circular(15),
              topRight: Radius.circular(15),
            ),
            child: Image.network(
              imagenUrl,
              height: 150,
              width: double.infinity,
              fit: BoxFit.cover,
              errorBuilder: (context, error, stackTrace) {
                return Container(
                  height: 150,
                  color: AppColors.backgroundColor,
                  child: Icon(
                    icono,
                    size: 50,
                    color: AppColors.accentColor,
                  ),
                );
              },
            ),
          ),

          // Content
          Padding(
            padding: const EdgeInsets.all(15.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    Icon(
                      icono,
                      color: AppColors.accentColor,
                      size: 24,
                    ),
                    const SizedBox(width: 10),
                    Text(
                      titulo,
                      style: TextStyle(
                        fontSize: 20,
                        fontWeight: FontWeight.bold,
                        color: AppColors.textDark,
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 8),
                Text(
                  descripcion,
                  style: TextStyle(
                    fontSize: 14,
                    color: AppColors.textSecondary,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}