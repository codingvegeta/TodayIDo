#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define BYTE_MASK 0xff

int main()
{
	unsigned int rgba_color = 0x66CDAAFF;

	unsigned char red, green, blue, alpha;

	alpha = rgba_color & BYTE_MASK;
	blue = (rgba_color >> 8) & BYTE_MASK;
	green = rgba_color >> 16 & BYTE_MASK;
	red = rgba_color >> 24 & BYTE_MASK;

	printf("(R, G, B, A) = (%hhu, %hhu, %hhu, %hhu)\n", red, green, blue , alpha);
}
