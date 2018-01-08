clc;
clear all;
close all;

%part-B
%1
n=-1:10;
x=.5.^heaviside(n);
subplot(10,4,1);
stem(n,x)

h=heaviside(n);
subplot(10,4,2);
stem(n,h)

lx=length(x);
lh=length(h);
ly=lx+lh-1;
y=zeros(1,ly);
for i=lh+1:ly
    h(i)=0;
end
for i=lx+1:ly
    x(i)=0;
end

for n=1:ly
    for k=1:lh
       if((n-k)<=0) y(n)=y(n)+(x(k)*h(1));
       else y(n)=y(n)+(x(k)*h(n-k+1));
       end
    end
end

n=-1:21;
%using in-built fuction
z=conv(x,h);
subplot(10,4,3);
stem(n,y)
hold on
n=-1:43;
subplot(10,4,4);
stem(n,z,'--r')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

n=-1:10;
x=2*(heaviside(n)-heaviside(n-5));
subplot(10,4,5);
stem(n,x)

h=1*(heaviside(n)-heaviside(n-4));
subplot(10,4,6);
stem(n,h)

lx=length(x);
lh=length(h);
ly=lx+lh-1;
y=zeros(1,ly);
for i=lh+1:ly
    h(i)=0;
end
for i=lx+1:ly
    x(i)=0;
end

for n=1:ly
    for k=1:lh
       if((n-k)<=0) y(n)=y(n)+(x(k)*h(1));
       else y(n)=y(n)+(x(k)*h(n-k+1));
       end
    end
end

n=-1:21;
%using in-built fuction
z=conv(x,h);
subplot(10,4,7);
stem(n,y)
hold on
n=-1:43;
subplot(10,4,8);
stem(n,z,'--r');
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

n=-1:10;
x=.5.^heaviside(n);
subplot(10,4,9);
stem(n,x)

h=.7.^heaviside(n);
subplot(10,4,10);
stem(n,h)

lx=length(x);
lh=length(h);
ly=lx+lh-1;
y=zeros(1,ly);
for i=lh+1:ly
    h(i)=0;
end
for i=lx+1:ly
    x(i)=0;
end

for n=1:ly
    for k=1:lh
       if((n-k)<=0) y(n)=y(n)+(x(k)*h(1));
       else y(n)=y(n)+(x(k)*h(n-k+1));
       end
    end
end

n=-1:21;
%using in-built fuction
z=conv(x,h);
subplot(10,4,11);
stem(n,y)
hold on
n=-1:43;
subplot(10,4,12);
stem(n,z,'--r');
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


n=-1:10;
x=ramp2(n).*(heaviside(n)-heaviside(n-6));
subplot(10,4,13);
stem(n,x)

h=ramp2(n).*(heaviside(n)-heaviside(n-5));
subplot(10,4,14);
stem(n,h)

lx=length(x);
lh=length(h);
ly=lx+lh-1;
y=zeros(1,ly);
for i=lh+1:ly
    h(i)=0;
end
for i=lx+1:ly
    x(i)=0;
end

for n=1:ly
    for k=1:lh
       if((n-k)<=0) y(n)=y(n)+(x(k)*h(1));
       else y(n)=y(n)+(x(k)*h(n-k+1));
       end
    end
end

n=-1:21;
%using in-built fuction
z=conv(x,h);
subplot(10,4,15);
stem(n,y)
hold on
n=-1:43;
subplot(10,4,16);
stem(n,z,'--r');
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

n=-1:10;
x=sin(2*pi*n/8).*(heaviside(n)-heaviside(n-4));
subplot(10,4,17);
stem(n,x)

h=(2.^(-n)).*(heaviside(n));
subplot(10,4,18);
stem(n,h)

lx=length(x);
lh=length(h);
ly=lx+lh-1;
y=zeros(1,ly);
for i=lh+1:ly
    h(i)=0;
end
for i=lx+1:ly
    x(i)=0;
end

for n=1:ly
    for k=1:lh
       if((n-k)<=0) y(n)=y(n)+(x(k)*h(1));
       else y(n)=y(n)+(x(k)*h(n-k+1));
       end
    end
end

n=-1:21;
%using in-built fuction
z=conv(x,h);
subplot(10,4,19);
stem(n,y)
hold on
n=-1:43;
subplot(10,4,20);
stem(n,z,'--r');
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
n=-1:3;
x={1,2,3,4,5};
subplot(10,4,21);
stem(n,x)

h = {1,2,1,-1};
subplot(10,4,22);
stem(n,h)

lx=length(x);
lh=length(h);
ly=lx+lh-1;
y=zeros(1,ly);
for i=lh+1:ly
    h(i)=0;
end
for i=lx+1:ly
    x(i)=0;
end

for n=1:ly
    for k=1:lh
       if((n-k)<=0) y(n)=y(n)+(x(k)*h(1));
       else y(n)=y(n)+(x(k)*h(n-k+1));
       end
    end
end

n=-1:21;
%using in-built fuction
z=conv(x,h);
subplot(10,4,15);
stem(n,y)
hold on
n=-1:43;
subplot(10,4,16);
stem(n,z,'--r');