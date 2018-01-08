clc;
clear all;
close all;
k = rand;
x = -10:1:10;
t = -10-k:1:10-k;
y1=@cos;
z1=heaviside(y1(x-k))-heaviside(y1(t));
if abs(z1)<0.01
    disp('Time invariance');
else
   disp('Time variant');
end

k = rand;
x = -10:1:10;
t = -10-k:1:10-k;
y2=@cos;
z1 = y2(x-5-k)-y2(3-k-x)-(y2(t-5)-y2(3-t));
if abs(z1)<0.01
    disp('Time invariance');
else
   disp('Time variant');
end

k = rand;
x = -10:1:10;
t = -10-k:1:10-k;
y1=@cos;
z1 = y1(x-k)/y1(x-k-1)-(y1(t)/y1(t-1));
if abs(z1)<0.01
    disp('Time invariance');
else
   disp('Time variant');
end

k = rand;
x = -10:1:10;
t = -10-k:1:10-k;
y1=@cos;
z1 = y1(x/2-k)-y1(t);
if abs(z1)<0.01
    disp('Time invariance');
else
   disp('Time variant');
end

k = rand;
x = -10:1:10;
t = -10-k:1:10-k;
y1=@cos;
z1 = y1(x-k).*cos(2*pi*x) -y1(t).*cos(2*pi*x);

if abs(z1)<0.01
    disp('Time invariance');
else
   disp('Time variant');
end


k = rand;
x = -10:1:10;
t = -10-k:1:10-k;
y1=@cos;
z1 = (y1(x-k)).^5-(y1(t)).^5;

if abs(z1)<0.01
    disp('Time invariance');
else
   disp('Time variant');
end

k = rand;
x = -10:1:10;
t = -10-k:1:10-k;
y2=@cos;
z1 = exp(y2(x-k))-exp(y2(t));
if abs(z1)<0.01
    disp('Time invariance');
else
   disp('Time variant');
end

k = rand;
x = -10:1:10;
t = -10-k:1:10-k;
y1=@cos;
z1 = diff(y1(x-k))-diff(y1(t));
if abs(z1)<0.01
    disp('Time invariance');
else
   disp('Time variant');
end

k = rand;
x = -10:1:10;
t = -10-k:1:10-k;
y1=@cos;
z1 = diff(y1(x-k-1))-diff(y1(t-1));
if abs(z1)<0.01
    disp('Time invariance');
else
   disp('Time variant');
end

k=rand;
t=(-10:0.01:10)';
to=(-10-k:0.01:10-k)';
x2=@sin;
if(abs(x2(t(2:end)-k).*diff(x2(t-k))-x2(to(2:end)).*diff(x2(to)))<0.0000001)
    disp('Time invariant');
else
    disp('Time Varint');
end;

if(abs(x2(t(2:end)-k-1).*diff(x2(t-k-1))-x2(to(2:end)-1).*diff(x2(to-1)))<0.0000001)
    disp('Time invariant');
else
    disp('Time Varint');
end;