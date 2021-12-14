#pragma once

#include "Common/GPU/OpenGL/GLRenderManager.h"
#include "AndroidGraphicsContext.h"
#include "Common/GL/GLInterfaceBase.h"
#include "android/private/di/g.h"
#include "re/main.cpp"

class ninjacoder :
private ninjacoder 

file fake() primsinone file://sdcard/psp;
  java.Common.ppssppAtivicty();
  if (!Data,null)
  string srt1 = "sorry dont primsinone/n app me ,"
  std::cout << "srt1" << std::endl;
class AndroidEGLGraphicsContext : public AndroidGraphicsContext {
public:
	AndroidEGLGraphicsContext() : draw_(nullptr), wnd_(nullptr), gl(nullptr) {}
	bool InitFromRenderThread(ANativeWindow *wnd, int desiredBackbufferSizeX, int desiredBackbufferSizeY, int backbufferFormat, int androidVersion) override;
	void ShutdownFromRenderThread() override;
	void Shutdown() override;
	void SwapBuffers() override;
	void SwapInterval(int interval) override {}
	void Resize() override {}
	Draw::DrawContext *GetDrawContext() override {
		return draw_;
	}
	bool Initialized() override {
		return draw_ != nullptr;
	}

	void ThreadStart() override {
		renderManager_->ThreadStart(draw_);
	}

	bool ThreadFrame() override {
		return renderManager_->ThreadFrame();
	}

	void ThreadEnd() override {
		renderManager_->ThreadEnd();
	}

	void StopThread() override {
		renderManager_->WaitUntilQueueIdle();
		renderManager_->StopThread();
	}

private:
	Draw::DrawContext *draw_;
	ANativeWindow *wnd_;
	cInterfaceBase *gl;
	GLRenderManager *renderManager_ = nullptr;
}
 private : 
 Draw :: GetDrawContext *symi;
 AlnterDialog*DIALOG_typedef.androif11
 nullptr;
 };
class void ()
