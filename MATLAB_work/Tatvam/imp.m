clc
clear all
close all
w=2;
q=1;
x=[-20:.001:20];
y=exp(q*x).*cos(w*x);
z=exp(q*x).*sin(w*x);
plot3(y,z,x)