clc;
clear all;
close all;
x = -10:1:10;
y1=@exp;
y2=@cos;
z1=heaviside(y1(x));
z2=heaviside(y2(x));
z3 = 3*z1+2*z2;
subplot(5,5,1);
plot(z3);
z1=heaviside(3*y1(x));
z2=heaviside(2*y2(x));
z4 = z1+z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,2);
plot(z3);

x = -10:1:10;
y1=@exp;
y2=@cos;
z1 = y1(x-5)-y1(3-x);
z2 = y2(x-5)-y2(3-x);
z3 = 2*z1 + 3*z2;
subplot(5,5,3);
plot(z3);
z1 = 2*(y1(x-5)-y1(3-x));
z2 = 3*(y2(x-5)-y2(3-x));
z4 = z1+z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,4);
plot(z3);

x = -10:1:10;
y1=@exp;
y2=@cos;
z1 = y1(x)/y1(x-1);
z2 = y2(x)/y2(x-1);
z3 = 2*z1 + 3*z2;
subplot(5,5,5);
plot(z3);
z1 = (y1(x)/y1(x-1));
z2 = (y2(x)/y2(x-1));
z4 = z1 + z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,6);
plot(z3);

x = -10:1:10;
y1=@exp;
y2=@cos;
z1 = y1(x/2);
z2 = y2(x/2);
z3 = 2*z1 + 3*z2;
subplot(5,5,7);
plot(z3);
z1 = 2*y1(x/2);
z2 = 3*y2(x/2);
z4 = z1 + z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,8);
plot(z3);

x = -10:1:10;
y1=@exp;
y2=@cos;
z1 = y1(x).*cos(2*pi*x);
z2 = y2(x).*cos(2*pi*x);
z3 = 2*z1 + 3*z2;
subplot(5,5,9);
plot(z3);
z1 = 2*y1(x).*cos(2*pi*x);
z2 = 3*y2(x).*cos(2*pi*x);
z4 = z1 + z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,10);
plot(z3);

x = -10:1:10;
y1=@exp;
y2=@cos;
z1 = (y1(x)).^5;
z2 = (y2(x)).^5;
z3 = 2*z1 + 3*z2;
subplot(5,5,11);
plot(z3);
z1 = (2*y1(x)).^5;
z2 = (3*y2(x)).^5;
z4 = z1 + z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,12);
plot(z3);

x = -10:1:10;
y1=@exp;
y2=@cos;
z1 = exp(y1(x));
z2 = exp(y2(x));
z3 = 2*z1 + 3*z2;
subplot(5,5,13);
plot(z3);
z1 = exp(2*y1(x));
z2 = exp(3*y2(x));
z4 = z1 + z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,14);
plot(z3);

x = -10:1:10;
y1=@exp;
y2=@cos;
z1 = diff(y1(x));
z2 = diff(y2(x));
z3 = 2*z1 + 3*z2;
subplot(5,5,14);
plot(z3);
z1 = diff(2*y1(x));
z2 = diff(3*y2(x));
z4 = z1 + z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,15);
plot(z3);

x = -10:1:10;
y1=@exp;
y2=@cos;
z1 = diff(y1(x-1));
z2 = diff(y2(x-1));
z3 = 2*z1 + 3*z2;
subplot(5,5,16);
plot(z3);
z1 = diff(2*y1(x-1));
z2 = diff(3*y2(x-1));
z4 = z1 + z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,17);
plot(z3);

x1 = -10:1:9;
x2 = -10:1:10;
y1=@exp;
y2=@cos;
z1 = (y1(x1)).*diff(y1(x2));
z2 = (y2(x1)).*diff(y2(x2));
z3 = 2*z1 + 3*z2;
subplot(5,5,18);
plot(z3);
z1 = (2*y1(x1)).*diff(2*y1(x2));
z2 = (3*y2(x1)).*diff(3*y2(x2));
z4 = z1 + z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,19);
plot(z3);

x1 = -10:1:9;
x2 = -10:1:10;
y1=@exp;
y2=@cos;
z1 = (y1(x1)).*diff(y1(x2-1));
z2 = (y2(x1)).*diff(y2(x2-1));
z3 = 2*z1 + 3*z2;
subplot(5,5,18);
plot(z3);
z1 = (2*y1(x1)).*diff(2*y1(x2-1));
z2 = (3*y2(x1)).*diff(3*y2(x2-1));
z4 = z1 + z2;
if abs(z4-z3)<0.01
    disp('linear');
else
    disp('non-linear');
end
subplot(5,5,19);
plot(z3);